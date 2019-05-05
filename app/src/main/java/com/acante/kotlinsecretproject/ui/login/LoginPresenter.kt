package com.acante.kotlinsecretproject.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
private const val TAG = "LoginPresenter"

class LoginPresenter (val context: Context): LoginContract.Presenter {
    private lateinit var auth: FirebaseAuth
    lateinit var view:LoginContract.View



    override fun login(email:String,password:String) {
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


    override fun attache(view: LoginContract.View) {
        this.view = view
        auth = FirebaseAuth.getInstance()

    }
}