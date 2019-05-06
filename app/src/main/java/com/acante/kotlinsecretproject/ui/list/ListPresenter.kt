package com.acante.kotlinsecretproject.ui.list

import android.util.Log
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.utils.Constance
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ListPresenter @Inject constructor() : ListContract.Presenter {

    lateinit var listAdapter: ListAdapter
    lateinit var view: ListContract.View
    private lateinit var api: RequestInterface

    override fun sendData(movieData: MovieData) {
//        api.postUser(movieData)
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "message : $it")
//            }, {
//                Log.d(TAG, "Message: ${it.localizedMessage}")
//            })
        api.postLoginTo().subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.setTitle(it)
            },{
                Log.d(ListPresenter.TAG, "error message : $it.localizedMessage")
            })
    }

    override fun loadSimpleText(text: String) {
        api.getPrivateData("3cc3a984-bd34-44c2-b8ef-ad3d2dde64a8")
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.setTitle(it)
                }, {
                    Log.d(ListPresenter.TAG, "error message : $it.localizedMessage")
                }
            )
    }

    override fun loadData() {
        api.getData()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dataLoaded(it)
                }, {
                    Log.d(ListPresenter.TAG, "error message : $it.localizedMessage")
                }
            )
        api.getTocken("my-trusted-client").subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG,"tocken:  $it")
            },{
                Log.d(TAG,"tocken:  ${it.localizedMessage}")
            })
    }

    override fun attache(view: ListContract.View) {
        this.view = view
        api = RequestInterface.create()
    }


    companion object {
        val TAG: String = "List Presenter"
    }
}