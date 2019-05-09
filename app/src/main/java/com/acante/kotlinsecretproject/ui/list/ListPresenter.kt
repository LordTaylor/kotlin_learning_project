package com.acante.kotlinsecretproject.ui.list

import com.acante.kotlinsecretproject.di.component.DaggerRepoComponent
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import kotlinx.coroutines.*
import javax.inject.Inject

class ListPresenter @Inject constructor() : ListContract.Presenter {

    lateinit var listAdapter: ListAdapter
    lateinit var view: ListContract.View
    lateinit var repo: Repo

    init {

    }
    override fun attache(view: ListContract.View,activity: BaseActivity) {
        this.view = view
        repo=activity.getMyRepo()
        listAdapter=ListAdapter(activity)
//        api = RequestInterface.create()
    }

    override fun sendData(movieData: MovieData) {
//        repo.api.postUser(movieData)
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d(TAG, "message : $it")
//            }, {
//                Log.d(TAG, "Message: ${it.localizedMessage}")
//            })
    }


    override fun loadSimpleText(text: String) {
//        api.getPrivateData(repo.session.getAuthentication(), token = repo.session.tokenResponse.getAccessToken()!!)
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    view.setTitle(it)
//                }, {
//                    Log.d(ListPresenter.TAG, "error message load simple text: ${(it.localizedMessage)}")
//                }
//            )
    }

    override fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Unconfined) {
                repo.loadData2(this@ListPresenter)
            }
        }
    }


    companion object {
        val TAG: String = "List Presenter"
    }
}