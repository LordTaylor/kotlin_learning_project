package com.acante.kotlinsecretproject.ui.list

import android.annotation.SuppressLint
import android.util.Log
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.api.Session
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
    private lateinit var session: Session

    override fun sendData(movieData: MovieData) {
        api.postUser(movieData)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "message : $it")
            }, {
                Log.d(TAG, "Message: ${it.localizedMessage}")
            })
    }

    @SuppressLint("CheckResult")
    override fun loadSimpleText(text: String) {
        api.getPrivateData(session.getAuthentication(),token = session.tokenResponse.getAccessToken()!!)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.setTitle(it)
                }, {
                    Log.d(ListPresenter.TAG, "error message load simple text: ${(it.localizedMessage)}")
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
    }

    override fun attache(view: ListContract.View) {
        this.view = view
        api = RequestInterface.create()
    }

    override fun addSession(session: Session) {
        this.session = session
    }


    companion object {
        val TAG: String = "List Presenter"
    }
}