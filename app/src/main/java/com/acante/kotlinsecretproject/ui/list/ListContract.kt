package com.acante.kotlinsecretproject.ui.list

import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.base.BaseCotract
import dagger.Provides

interface ListContract{
    interface Presenter:BaseCotract.Presenter<View>{
        fun loadData()
        fun sendData(movieData: MovieData)

    }
    interface View : BaseCotract.View{
        fun editItem(id:Int)
        fun addItem()
        fun dataLoaded(data: List<MovieData>)
    }
}