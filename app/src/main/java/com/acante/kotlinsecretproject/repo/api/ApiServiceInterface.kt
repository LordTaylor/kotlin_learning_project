package com.acante.kotlinsecretproject.repo.api

import com.acante.kotlinsecretproject.repo.model.MovieData
import io.reactivex.Observable
import retrofit2.http.GET
import com.acante.kotlinsecretproject.repo.model.Repo
import com.acante.kotlinsecretproject.utils.Constance
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path


interface ApiServiceInterface {

    @GET("/jsony")
    fun getData():Observable<List<MovieData>>

    @GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") owner: String, @Path("name") name: String): Single<Repo>

    companion object Factory{
        fun create():ApiServiceInterface{
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constance.BASE_URL)
                .build()
            return retrofit.create(ApiServiceInterface::class.java)
        }

    }

}