package com.acante.kotlinsecretproject.ui.register

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface RegisterContract: BaseCotract{
    interface View :BaseCotract.View{
        fun showListFragment()
        fun showLoginFragment()

    }
    interface Presenter : BaseCotract.Presenter<View>{
        fun userRegister( email:String, password:String)
        fun validateCredentials(email:String,password:String,confirmPassword:String):Boolean
    }
}