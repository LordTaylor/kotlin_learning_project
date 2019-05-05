package com.acante.kotlinsecretproject.ui.main

class MainPresenter: MainContract.Presenter{
    lateinit var view: MainContract.View
    override fun attache(view: MainContract.View) {
        this.view = view
        view.showRegistreFragment()
    }
}