package com.acante.kotlinsecretproject.repo.model

import com.google.gson.Gson

class DetailsViewModel(data: List<MovieData>) {

    fun toJson(): String {
        return Gson().toJson(this)
    }
}