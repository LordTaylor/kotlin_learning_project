package com.acante.kotlinsecretproject.ui.base


class BaseContact {

    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attache(view: View)
    }
    interface View{}

}