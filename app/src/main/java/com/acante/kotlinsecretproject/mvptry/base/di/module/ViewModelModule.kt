package com.acante.kotlinsecretproject.mvptry.base.di.module

import androidx.lifecycle.ViewModel
import com.acante.kotlinsecretproject.mvptry.base.di.component.ApplicationComponent
import com.acante.kotlinsecretproject.di.component.DaggerApplicationComponent

class ViewModelModule : ViewModel(){

    fun ViewModelModule(){

        var applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()

    }
    
}