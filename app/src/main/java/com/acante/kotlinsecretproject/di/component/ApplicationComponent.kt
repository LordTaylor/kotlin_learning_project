package com.acante.kotlinsecretproject.di.component

import android.app.Activity
import android.app.Application
import com.acante.kotlinsecretproject.base.BaseApplication
import com.acante.kotlinsecretproject.di.module.ActivityBindingModule
import com.acante.kotlinsecretproject.di.module.ApplicationModule
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.Repo
import dagger.Component

@Component (modules = arrayOf(ApplicationModule::class,ActivityBindingModule::class, FragmentModule::class))
interface ApplicationComponent{

    fun inject(app:BaseApplication)

    fun buildActivity(activity:Activity)
}