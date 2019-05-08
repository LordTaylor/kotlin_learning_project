package com.acante.kotlinsecretproject.ui.login

import com.acante.kotlinsecretproject.api.Session
import com.acante.kotlinsecretproject.ui.base.BaseCotract
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseUser

interface LoginContract : BaseCotract {


    interface View : BaseCotract.View {
        fun showListFragment(user: FirebaseUser)
        fun showListFragment(email: String)
        fun showRegisterFragment()
        fun setEmail(email: String = "")
        fun showLoginErrorMessage()
    }

    interface Presenter : BaseCotract.Presenter<View> {
        fun login(email: String, password: String)
        fun loginToRest(username: String, password: String)
    }
}