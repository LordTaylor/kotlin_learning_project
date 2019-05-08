package com.acante.kotlinsecretproject.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.api.Session
import com.acante.kotlinsecretproject.di.component.DaggerRepoComponent
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.repo.model.User
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

private const val TAG = "LoginPresenter"

class LoginPresenter(val context: Context) : LoginContract.Presenter {
//    private lateinit var auth: FirebaseAuth
    lateinit var view: LoginContract.View

    lateinit var repo: Repo

    override fun loginToRest(userName: String, password: String) {

        repo.getToken(userName,password,this)
    }

    override fun login(email: String, password: String) {
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener() { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithEmail:success")
//                    val user = auth.currentUser
////                    updateUI(user)
//                    view.showListFragment(user!!)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithEmail:failure", task.exception)
//                    Toast.makeText(
//                        context, "Authentication failed.",
//                        Toast.LENGTH_SHORT
//                    ).show()
////                    updateUI(null)
//                }
//            }
    }

    override fun attache(view: LoginContract.View,activity: BaseActivity) {
        this.view = view
//        auth = FirebaseAuth.getInstance()
        repo=activity.getMyRepo()
    }

    fun injectDependency() {
        var repoComponent = DaggerRepoComponent.create()
        repoComponent.inject(this)
    }
}