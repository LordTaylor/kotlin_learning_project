package com.acante.kotlinsecretproject.ui.detail

class DetailPresenter : DetailContract.Presenter {
    lateinit var view : DetailContract.View
    override fun attache(view: DetailContract.View) {
        this.view= view
    }
}