package com.acante.kotlinsecretproject.ui.list

import android.util.Log
import com.acante.kotlinsecretproject.repo.model.DetailsViewModel
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.Post
import com.acante.kotlinsecretproject.repo.rest.RequestInterface
import com.acante.kotlinsecretproject.ui.base.BaseContact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListPresenter : ListContract.Presenter {
    val TAG = "ListPresenter"

    private val subscription = CompositeDisposable()

    private val api: RequestInterface = RequestInterface.create()

    private lateinit var view: ListContract.View

    override fun loadDalta() {
        var subscribe = api.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showProggres(false)
                view.loadDataSuccsess(it!!)
            }, {
                Log.d(TAG, it.message)
                view.showProggres(false)
                view.showErrorMessage(it.localizedMessage)
            })
    }

    override fun loadDatalAll() {
//        var subscribe = Observable.zip(api.getData())
    }

    override fun deleteItem(Item: Post) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscription.clear()
    }

    override fun attache(view: BaseContact.View) {
        this.view = view as ListContract.View
    }

    private fun createDetalView(movieData: List<MovieData>):DetailsViewModel{
        var data = movieData
        return DetailsViewModel(data)
    }
}