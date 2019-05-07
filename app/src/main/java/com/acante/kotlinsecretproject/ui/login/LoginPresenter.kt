package com.acante.kotlinsecretproject.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.api.Session
import com.acante.kotlinsecretproject.repo.model.User
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val TAG = "LoginPresenter"

class LoginPresenter (val context: Context): LoginContract.Presenter {
    private lateinit var auth: FirebaseAuth
    lateinit var view:LoginContract.View
    lateinit var api:RequestInterface
    lateinit var session:Session

    override fun loginToRest(userName: String, password: String) {
        session= Session()
        api.getToken(au = session.getAuthentication(), grant_type = "password", username = userName,password = password).subscribeOn(
            Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                session.addTocken(it)
                session.addUser(User(userName,userName))
                view.showListFragment(session)
            },{
                Log.d(TAG,"tocken error:  $it")
                view.showLoginErrorMessage()
            })
    }

    override fun login(email:String,password:String) {
        if(loginGithub(pass = password)){
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
//                    updateUI(user)
                    view.showListFragment(user!!)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    updateUI(null)
                }
            }
    }
    fun loginGithub(email:String = "krawczyk.jaroslaw84@gmail.com",pass:String):Boolean{

        return false
    }


    override fun attache(view: LoginContract.View) {
        this.view = view
        auth = FirebaseAuth.getInstance()
        api = RequestInterface.create()

    }
}