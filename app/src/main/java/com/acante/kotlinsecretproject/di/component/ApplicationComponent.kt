package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.base.BaseApplication
import com.acante.kotlinsecretproject.di.module.ApplicationModule
import dagger.Component

@Component (modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent{

    fun inject(app:BaseApplication)

}