package com.acante.kotlinsecretproject.di.module

import android.app.Activity
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity : Activity){

    @Provides
    fun provideActivity():Activity{
        return activity
    }

    @Provides
    fun providePresenter():MainContract.Presenter{
        return MainPresenter()
    }
}