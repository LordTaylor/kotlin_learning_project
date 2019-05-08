package com.acante.kotlinsecretproject.di.component

import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.acante.kotlinsecretproject.ui.list.ListAdapter
import com.acante.kotlinsecretproject.ui.list.ListPresenter
import com.acante.kotlinsecretproject.ui.login.LoginPresenter
import dagger.Component
import dagger.Reusable
import javax.inject.Singleton


@Singleton
@Component
interface RepoComponent {
    fun inject(app:BaseActivity)
    fun inject(listPresenter: ListPresenter)
    fun inject(repo: Repo)
    fun inject(adapter: ListAdapter)
    fun inject(loginPresenter: LoginPresenter)
}