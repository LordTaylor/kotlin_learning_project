package com.acante.kotlinsecretproject.ui.register

class RegisterPresenter : RegisterContract.Presenter {
    lateinit var view:RegisterContract.View
    override fun userRegister() {

    }

    override fun attache(view: RegisterContract.View) {
        this.view = view
    }
}