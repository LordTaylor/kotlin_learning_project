package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.MainActivity
import com.acante.kotlinsecretproject.di.module.ActivityModule
import dagger.Component


@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity:MainActivity)
}