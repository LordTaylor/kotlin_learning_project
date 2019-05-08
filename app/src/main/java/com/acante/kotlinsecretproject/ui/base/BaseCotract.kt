package com.acante.kotlinsecretproject.ui.base

interface BaseCotract {
    interface Presenter<in T>{

        fun attache(view: T,activity: BaseActivity)
    }
    interface View{

    }
}