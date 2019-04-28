package com.acante.kotlinsecretproject.di.module

import androidx.lifecycle.ViewModel
import com.acante.kotlinsecretproject.di.component.ApplicationComponent
import com.acante.kotlinsecretproject.di.component.DaggerApplicationComponent

class ViewModelModule : ViewModel(){

    fun ViewModelModule(){

        var applicationComponent:ApplicationComponent = DaggerApplicationComponent.create()

    }
    
}