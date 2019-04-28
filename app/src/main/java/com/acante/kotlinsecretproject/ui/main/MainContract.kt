package com.acante.kotlinsecretproject.ui.main

import com.acante.kotlinsecretproject.ui.base.BaseContract

class MainContract {

    interface View:BaseContract.View{
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter:BaseContract.Presenter<MainContract.View>{
        fun onDrawerOptionAboutClick()
    }
}