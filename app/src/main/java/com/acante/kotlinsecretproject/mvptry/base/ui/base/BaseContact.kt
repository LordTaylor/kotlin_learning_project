package com.acante.kotlinsecretproject.mvptry.base.ui.base


class BaseContact {

    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attache(view: View)
    }
    interface View{}

}