package com.acante.kotlinsecretproject.mvptry.base.ui.about

import com.acante.kotlinsecretproject.mvptry.base.ui.base.BaseContact

class AboutContract {
    interface View: BaseContact.View{
        fun loadMessageSuccess(message:String)
        fun showProggres(shw:Boolean)
    }

    interface Presenter:
        BaseContact.Presenter<View>{
        fun showMessage()
    }
}