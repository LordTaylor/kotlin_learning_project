package com.acante.kotlinsecretproject.ui.main

import com.acante.kotlinsecretproject.ui.base.BaseActivity

class MainPresenter: MainContract.Presenter{
    lateinit var view: MainContract.View
    override fun attache(view: MainContract.View,activity: BaseActivity) {
        this.view = view
        view.getUserEmail()
    }
}