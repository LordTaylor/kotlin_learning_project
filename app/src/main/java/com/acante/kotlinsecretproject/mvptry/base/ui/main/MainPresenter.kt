package com.acante.kotlinsecretproject.mvptry.base.ui.main

import com.acante.kotlinsecretproject.mvptry.base.ui.base.BaseContact
import io.reactivex.disposables.CompositeDisposable

class MainPresenter : MainContract.Presenter {

    private val  subscription = CompositeDisposable()

    private lateinit var view: MainContract.View

    override fun onDrawerOptionAboutClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscription.clear()
    }

    override fun attache(view: BaseContact.View) {
        this.view = view as MainContract.View
    }
}