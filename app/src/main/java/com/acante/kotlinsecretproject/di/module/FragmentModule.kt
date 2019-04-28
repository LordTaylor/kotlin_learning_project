package com.acante.kotlinsecretproject.di.module

import com.acante.kotlinsecretproject.repo.api.ApiServiceInterface
import com.acante.kotlinsecretproject.ui.about.AboutContract
import com.acante.kotlinsecretproject.ui.about.AboutPresenter
import com.acante.kotlinsecretproject.ui.list.ListContract
import com.acante.kotlinsecretproject.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule  {

    @Provides
    fun provideAboutPresenter():AboutContract.Presenter{
        return AboutPresenter()
    }

    @Provides
    fun provideListPresenter():ListContract.Presenter{
        return ListPresenter()
    }

    @Provides
    fun provideRequestInterface():ApiServiceInterface{
        return ApiServiceInterface.create()
    }
}