package com.acante.kotlinsecretproject.api

import com.acante.kotlinsecretproject.repo.model.MovieData
import io.reactivex.Observable
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.utils.Constance
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface RequestInterface {

    @GET("/jsony")
    fun getData():Observable<List<MovieData>>

    @GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") owner: String, @Path("name") name: String): Single<Repo>

    companion object Factory{
        fun create(): RequestInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constance.BASE_URL)
                .build()
            return retrofit.create(RequestInterface::class.java)
        }

    }
    @POST("/")
    fun postUser(@Body movieData: MovieData):Single<MovieData>

    @GET("/private?access_token={token}")
    fun getPrivateData(@Path("token")token:String):Observable<String>

    @POST("/oauth/token?grant_type=password&username=user&password=pass")
    fun postLoginTo(@Query("user")user:String="user",@Query("pass")pass:String="user"):Observable<String>

    @POST("/oauth/token?grant_type=password&username=user&password=pass")
    @FormUrlEncoded
    fun getTocken(@Field("client_id")client_id:String,@Field("secret")secret:String="secret",@Query("user")user:String="user",@Query("pass")pass:String="pass"):Observable<TokenResponse>

}