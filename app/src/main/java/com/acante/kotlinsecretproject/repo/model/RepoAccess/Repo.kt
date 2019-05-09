package com.acante.kotlinsecretproject.repo.model.RepoAccess

import android.util.Log
import com.acante.kotlinsecretproject.api.ApiRetroCorutines
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

private const val TAG: String = "Repo"

@Reusable
class Repo @Inject constructor() {

    var movieList: MutableSet<MovieData> = mutableSetOf()

    private lateinit var api: RequestInterface

    private lateinit var api2: ApiRetroCorutines

    @Inject
    lateinit var session: Session

    init {
        initApi()
    }

    fun initApi() {
        api = RequestInterface.create()
        api2 = ApiRetroCorutines.create()
        injectDependency()
        getSession()
    }

    fun getSession() {

    }

    suspend fun loadData2(listPresenter: ListPresenter) {
        var request= api2.getData(session.getAuthentication(),session.tokenResponse.getAccessToken()!!)
        val response =request.await()
        if(response.isSuccessful){
            movieList.addAll(response.body()!!)
            listPresenter.listAdapter.setMovies(movieList)
            Log.d(TAG,"data loaded")
        }else{
            Log.d(TAG,"loading error ${response}")
        }
    }

    suspend fun getToken2(userName: String, password: String, loginPresenter: LoginPresenter): Boolean {

        var response = api2.getToken(
            auth = session.getAuthentication(),
            grant_type = "password",
            username = userName,
            password = password
        )

                val r = response.await()
                if (r.isSuccessful) {
                    session.addToken(r.body()!!)
                    session.addUser(User(userName, userName))
                    loginPresenter.view.showListFragment(userName)
                    return true
                }else{
                    return false
                }

        return false
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


