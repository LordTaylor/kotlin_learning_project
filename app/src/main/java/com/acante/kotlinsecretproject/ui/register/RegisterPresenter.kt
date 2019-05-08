package com.acante.kotlinsecretproject.ui.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.internal.schedulers.RxThreadFactory

private const val TAG = "RegisterPresenter"

class RegisterPresenter(val context: Context) : RegisterContract.Presenter {

    private lateinit var auth: FirebaseAuth
    lateinit var view: RegisterContract.View
    lateinit var repo: Repo

    override fun userRegister(email: String, password: String) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    view.showLoginFragment()
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        context, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    updateUI(null)
                }
            }
    }

    override fun attache(view: RegisterContract.View, activity: BaseActivity) {
        this.view = view
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            this.view.showListFragment()
            return
        }
        repo = activity.getMyRepo()
//        userRegister("herwin.elijon@gmail.com","Domdomdom1")
    }

    override fun validateCredentials(email: String, password: String, confirmPassword: String): Boolean {
        return password.equals(confirmPassword)
    }
}