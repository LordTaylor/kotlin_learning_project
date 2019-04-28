package com.acante.kotlinsecretproject.di.module

import android.app.Application
import com.acante.kotlinsecretproject.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp:BaseApplication) {

    @Provides
    @Singleton
    fun provideApplication():Application{
        return baseApp
    }
}