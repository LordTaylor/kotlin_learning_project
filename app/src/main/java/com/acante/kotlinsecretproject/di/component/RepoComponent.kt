package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.acante.kotlinsecretproject.ui.list.ListAdapter
import dagger.Component

@Component
interface RepoComponent {
    fun inject(app:BaseActivity)
    fun inject(listAdapter: ListAdapter)
}