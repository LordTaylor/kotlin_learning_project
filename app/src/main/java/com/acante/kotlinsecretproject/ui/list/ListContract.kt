package com.acante.kotlinsecretproject.ui.list

import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface ListContract{
    interface Presenter:BaseCotract.Presenter<View>{
        fun loadData()
    }
    interface View : BaseCotract.View{

        fun dataLoaded(data: List<MovieData>)
    }
}