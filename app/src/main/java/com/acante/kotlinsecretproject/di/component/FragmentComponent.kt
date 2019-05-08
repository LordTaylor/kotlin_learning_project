package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.MyListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent{
//
//    fun inject(fragmentMy:MyListFragment)
//
//    fun inject(fragment:DetailFragment)
}