package com.acante.kotlinsecretproject.mvptry.base.ui.main

import com.acante.kotlinsecretproject.mvptry.base.ui.base.BaseContact

class MainContract {

    interface View: BaseContact.View{
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter:
        BaseContact.Presenter<View>{
        fun onDrawerOptionAboutClick()
    }
}