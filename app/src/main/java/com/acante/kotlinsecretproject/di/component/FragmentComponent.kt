package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.ui.list.ListFragment
import dagger.Component

@Component (modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

//    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)
}