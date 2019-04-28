package com.acante.kotlinsecretproject.ui.list

import android.text.BoringLayout
import com.acante.kotlinsecretproject.repo.model.DetailsViewModel
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.Post
import com.acante.kotlinsecretproject.ui.base.BaseContact

class ListContract {

    interface View : BaseContact.View {
        fun showProggres(show:Boolean)
        fun showErrorMessage(error:String)
        fun loadDataSuccsess(list:List<MovieData>)
        fun loadDataAllSuccsess(model:DetailsViewModel)
    }


    interface Presenter : BaseContact.Presenter<View> {
        fun loadDalta()
        fun loadDatalAll()
        fun deleteItem(Item: Post)
    }

}