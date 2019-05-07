package com.acante.kotlinsecretproject.api

import android.util.Base64
import com.acante.kotlinsecretproject.repo.model.User
import com.acante.kotlinsecretproject.utils.Constance
import java.nio.charset.Charset

class Session() {
    lateinit var tokenResponse: TokenResponse
    lateinit var user:User

    fun addTocken(tokenResponse: TokenResponse) {
        this.tokenResponse = tokenResponse
    }

    fun getAuthentication(): String {
        var s: String = Constance.APP_NAME_AUTH + ":" + "secret"
        s = "Basic " + Base64.encodeToString(s.toByteArray(), Base64.DEFAULT).trim()
        return s
    }
    fun addUser(user: User){
        this.user = user
    }
    fun getSessionUser():User{
        return user
    }
}