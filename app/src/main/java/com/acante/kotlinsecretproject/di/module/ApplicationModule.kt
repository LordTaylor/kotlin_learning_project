package com.acante.kotlinsecretproject.di.module

import android.app.Application
import com.acante.kotlinsecretproject.base.BaseApplication
import com.acante.kotlinsecretproject.di.utils.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp:BaseApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication():Application{
        return baseApp
    }
}