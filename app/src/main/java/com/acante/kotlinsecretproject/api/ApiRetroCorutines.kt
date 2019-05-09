package com.acante.kotlinsecretproject.api

import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.utils.Constance
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiRetroCorutines {
    @GET("/private/movies")
    fun getData(@Header("Authorization") auth: String, @Query("access_token") token: String): Deferred<Response<List<MovieData>>>

    @POST("/oauth/token")
    @FormUrlEncoded
    fun getToken(
        @Header("Authorization") auth: String, @Field("grant_type") grant_type: String, @Field("username") username: String, @Field(
            "password"
        ) password: String
    ): Deferred<Response<TokenResponse>>

    companion object {
        fun create(): ApiRetroCorutines {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(Constance.BASE_URL)
                .build()
            return retrofit.create(ApiRetroCorutines::class.java)
        }
    }
}