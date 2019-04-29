package com.acante.kotlinsecretproject.mvptry.base.di.module

import com.acante.kotlinsecretproject.repo.rest.RequestInterface
import com.acante.kotlinsecretproject.mvptry.base.ui.about.AboutContract
import com.acante.kotlinsecretproject.mvptry.base.ui.about.AboutPresenter
import com.acante.kotlinsecretproject.mvptry.base.ui.list.ListContract
import com.acante.kotlinsecretproject.mvptry.base.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule  {

    @Provides
    fun provideAboutPresenter(): AboutContract.Presenter{
        return AboutPresenter()
    }

    @Provides
    fun provideListPresenter(): ListContract.Presenter{
        return ListPresenter()
    }

    @Provides
    fun provideRequestInterface():RequestInterface{
        return RequestInterface.create()
    }
}