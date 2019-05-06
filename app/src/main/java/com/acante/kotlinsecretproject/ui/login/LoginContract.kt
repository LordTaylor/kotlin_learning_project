package com.acante.kotlinsecretproject.ui.login

import com.acante.kotlinsecretproject.ui.base.BaseCotract
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseUser

interface LoginContract : BaseCotract {

    interface View : BaseCotract.View{
        fun showListFragment(user: FirebaseUser)
        fun showRegisterFragment()
        fun setEmail(email:String="")
    }
    interface Presenter : BaseCotract.Presenter<View>{
            fun login(email:String,password:String)
    }
}