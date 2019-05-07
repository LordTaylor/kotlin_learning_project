package com.acante.kotlinsecretproject.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenResponse {

    @SerializedName("token_type")
    @Expose
    private var tokenType: String? = null
    @SerializedName("expires_in")
    @Expose
    private var expiresIn: Int? = null
    @SerializedName("access_token")
    @Expose
    private var accessToken: String? = null

    fun getTokenType(): String? {
        return tokenType
    }

    fun setTokenType(tokenType: String) {
        this.tokenType = tokenType
    }

    fun getExpiresIn(): Int? {
        return expiresIn
    }

    fun setExpiresIn(expiresIn: Int?) {
        this.expiresIn = expiresIn
    }

    fun getAccessToken(): String? {
        return accessToken
    }

    fun setAccessToken(accessToken: String) {
        this.accessToken = accessToken
    }
}