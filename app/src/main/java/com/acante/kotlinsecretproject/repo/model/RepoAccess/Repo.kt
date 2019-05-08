package com.acante.kotlinsecretproject.repo.model.RepoAccess

import android.util.Log
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.api.Session
import com.acante.kotlinsecretproject.di.component.DaggerRepoComponent
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.User
import com.acante.kotlinsecretproject.ui.list.ListPresenter
import com.acante.kotlinsecretproject.ui.login.LoginPresenter
import dagger.Reusable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG: String = "Repo"
@Reusable
class Repo @Inject constructor() {

    var movieList: MutableSet<MovieData> = mutableSetOf()

    private lateinit var api: RequestInterface

    @Inject
    lateinit var session: Session

    init {
        initApi()
    }

    fun initApi() {
        api = RequestInterface.create()
        injectDependency()
        getSession()
    }

    fun getSession() {

    }

    fun loadData(listPresenter: ListPresenter) {
        if (::session.isInitialized) {
            api.getData(session.getAuthentication(), session.tokenResponse.getAccessToken()!!)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieList.addAll(it)
                    listPresenter.listAdapter.setMovies(movieList)
                }, {
                    Log.e(TAG, "ERROR :" + it.localizedMessage)
                })
        }

    }

    fun injectDependency() {
        var repoComponent = DaggerRepoComponent.create()
        repoComponent.inject(this)
    }


    companion object {
        val INSTANCE: Repo = Repo()
    }

    fun getToken(userName: String, password: String) {

        api.getToken(
            auth = session.getAuthentication(),
            grant_type = "password",
            username = userName,
            password = password
        ).subscribeOn(
            Schedulers.io()
        )
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                session.addToken(it)
                session.addUser(User(userName, userName))


            }, {
                Log.d(TAG, "tocken error:  $it")
            })
//        delay(2000, TimeUnit.MILLISECONDS)

    }

    fun getToken(userName: String, password: String, loginPresenter: LoginPresenter) {

        api.getToken(
            auth = session.getAuthentication(),
            grant_type = "password",
            username = userName,
            password = password
        ).subscribeOn(
            Schedulers.io()
        )
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                session.addToken(it)
                session.addUser(User(userName, userName))
                loginPresenter.view.showListFragment(userName)

            }, {
                Log.d(TAG, "tocken error:  $it")
                loginPresenter.view.showLoginErrorMessage()
            })
//        delay(2000, TimeUnit.MILLISECONDS)

    }
}


