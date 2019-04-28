package com.acante.kotlinsecretproject.ui.base


class BaseContract {

    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attache(view: T)
    }
    interface View{}

}