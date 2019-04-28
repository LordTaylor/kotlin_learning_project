package com.acante.kotlinsecretproject.ui.about

import com.acante.kotlinsecretproject.ui.base.BaseContract

class AboutContract {
    interface View:BaseContract.View{
        fun loadMessageSuccess(message:String)
        fun showProggres(shw:Boolean)
    }

    interface Presenter:BaseContract.Presenter<View>{
        fun showMessage()
    }
}