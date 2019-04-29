package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.MovieListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent{

    fun inject(fragment:MovieListFragment)

    fun inject(fragment:DetailFragment)
}