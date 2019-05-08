package com.acante.kotlinsecretproject.api

import android.util.Base64
import com.acante.kotlinsecretproject.repo.model.User
import com.acante.kotlinsecretproject.utils.Constance
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

class Session @Inject constructor() {
    lateinit var tokenResponse: TokenResponse
    lateinit var user: User
    private var valid:Boolean = false

    fun addToken(tokenResponse: TokenResponse) {
        this.tokenResponse = tokenResponse
        valid = true
    }

    fun getAuthentication(): String {
        var s: String = Constance.APP_NAME_AUTH + ":" + "secret"
        s = "Basic " + Base64.encodeToString(s.toByteArray(), Base64.DEFAULT).trim()
        return s
    }

    fun addUser(user: User) {
        this.user = user
    }

    fun getSessionUser(): User {
        return user
    }


    fun isSesionValid():Boolean {
        launch(UI) {
            withContext(coroutineContext){
                delay(1,TimeUnit.SECONDS)
                if(::tokenResponse.isInitialized){
                    valid = true
                }
            }
        }
        return valid
    }
//    companion object {
//        val INSTANCE: Session = Session()
//    }
}