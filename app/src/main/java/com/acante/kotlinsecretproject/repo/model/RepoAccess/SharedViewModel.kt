package com.acante.kotlinsecretproject.repo.model.RepoAccess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acante.kotlinsecretproject.repo.model.MovieData

class SharedViewModel: ViewModel() {
    var data:MutableLiveData<ArrayList<MovieData>> = MutableLiveData()

    fun addItem(movieData: MovieData){
        data.value?.add(movieData)
    }

    fun getItem(idx:Int): MovieData {
        return data.value?.get(idx)!!
    }

}