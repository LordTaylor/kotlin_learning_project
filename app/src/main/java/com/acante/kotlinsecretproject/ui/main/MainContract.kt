package com.acante.kotlinsecretproject.ui.main

import com.acante.kotlinsecretproject.ui.base.BaseContact

class MainContract {

    interface View:BaseContact.View{
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter:BaseContact.Presenter<MainContract.View>{
        fun onDrawerOptionAboutClick()
    }
}