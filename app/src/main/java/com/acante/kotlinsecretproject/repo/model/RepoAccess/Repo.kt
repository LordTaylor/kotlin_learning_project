package com.acante.kotlinsecretproject.repo.model.RepoAccess

import com.acante.kotlinsecretproject.repo.model.MovieData
import javax.inject.Inject


class Repo @Inject constructor(){

    lateinit var movieList: MutableSet<MovieData>

    companion object{
        val INSTANCE:Repo = Repo()
    }
}