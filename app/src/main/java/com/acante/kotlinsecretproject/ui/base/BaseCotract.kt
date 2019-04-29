package com.acante.kotlinsecretproject.ui.base

interface BaseCotract {
    interface Presenter<in T>{

        fun attache(view: T)
    }
    interface View{

    }
}