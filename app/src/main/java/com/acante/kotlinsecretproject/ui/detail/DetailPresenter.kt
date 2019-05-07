package com.acante.kotlinsecretproject.ui.detail

import javax.inject.Inject

class DetailPresenter @Inject constructor(): DetailContract.Presenter {
    lateinit var view : DetailContract.View
    override fun attache(view: DetailContract.View) {
        this.view= view
    }
}