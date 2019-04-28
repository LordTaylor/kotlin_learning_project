package com.acante.kotlinsecretproject.ui.list

import com.acante.kotlinsecretproject.repo.model.DetailsViewModel
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.Post
import com.acante.kotlinsecretproject.ui.base.BaseContract

class ListContract {

    interface View : BaseContract.View {
        fun showProgress(show:Boolean)
        fun showErrorMessage(error:String)
        fun loadDataSuccsess(list:List<MovieData>)
        fun loadDataAllSuccsess(model:DetailsViewModel)
    }


    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
        fun loadDatalAll()
        fun deleteItem(Item: Post)
    }

}