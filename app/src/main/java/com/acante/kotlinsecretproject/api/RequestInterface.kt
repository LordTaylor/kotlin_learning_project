package com.acante.kotlinsecretproject.api

import com.acante.kotlinsecretproject.repo.model.MovieData
import io.reactivex.Observable
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.utils.Constance
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit


interface RequestInterface {

    @GET("/private/list")
    fun getData(@Header("Authorization") auth: String,@Query("access_token") token: String): Observable<List<MovieData>>

    @GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") owner: String, @Path("name") name: String): Single<Repo>

    companion object {
        fun create(): RequestInterface {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constance.BASE_URL)
                .build()
            return retrofit.create(RequestInterface::class.java)
        }

    }

    @POST("/")
    fun postUser(@Body movieData: MovieData): Single<MovieData>

    @GET("/private")
    fun getPrivateData(@Header("Authorization") auth: String, @Query("access_token") token: String): Observable<String>


    @POST("/oauth/token")
    @FormUrlEncoded
    fun getToken(
        @Header("Authorization") auth: String, @Field("grant_type") grant_type: String, @Field("username") username: String, @Field(
            "password"
        ) password: String
    ): Observable<TokenResponse>

    @POST("/oauth/token")
    @FormUrlEncoded
    fun getToken2(
        @Header("Authorization") auth: String, @Field("grant_type") grant_type: String, @Field("username") username: String, @Field(
            "password"
        ) password: String
    ): Call<TokenResponse>

}