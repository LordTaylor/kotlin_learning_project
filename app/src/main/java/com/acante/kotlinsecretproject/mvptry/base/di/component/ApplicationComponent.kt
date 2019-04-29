package com.acante.kotlinsecretproject.mvptry.base.di.component

import android.app.Activity
import android.app.Application
import com.acante.kotlinsecretproject.mvptry.base.BaseApplication
import com.acante.kotlinsecretproject.mvptry.base.di.module.ActivityBindingModule
import com.acante.kotlinsecretproject.mvptry.base.di.module.ApplicationModule
import com.acante.kotlinsecretproject.mvptry.base.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.Repo
import dagger.Component

@Component (modules = arrayOf(
    ApplicationModule::class,
    ActivityBindingModule::class, FragmentModule::class))
interface ApplicationComponent{

    fun inject(app: BaseApplication)

    fun buildActivity(activity:Activity)
}