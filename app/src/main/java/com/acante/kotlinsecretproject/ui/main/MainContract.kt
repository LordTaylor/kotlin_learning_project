package com.acante.kotlinsecretproject.ui.main

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface MainContract {
    interface Presenter: BaseCotract.Presenter<View>
    interface View : BaseCotract.View{
        fun showLoginFragment(email:String = "")
        fun showListFragment()
        fun showDetailFragment()
        fun showRegistreFragment()
        fun getUserEmail()
    }
}