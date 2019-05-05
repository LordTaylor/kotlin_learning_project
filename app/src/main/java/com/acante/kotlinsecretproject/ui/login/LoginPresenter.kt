package com.acante.kotlinsecretproject.ui.login

class LoginPresenter : LoginContract.Presenter {
    lateinit var view:LoginContract.View
    override fun attache(view: LoginContract.View) {
        this.view = view
    }
}