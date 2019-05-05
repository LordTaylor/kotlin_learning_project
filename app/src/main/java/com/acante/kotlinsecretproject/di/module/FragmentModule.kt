package com.acante.kotlinsecretproject.di.module

import com.acante.kotlinsecretproject.ui.detail.DetailContract
import com.acante.kotlinsecretproject.ui.detail.DetailPresenter
import com.acante.kotlinsecretproject.ui.list.ListContract
import com.acante.kotlinsecretproject.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(view: ListContract.View): ListContract.Presenter{
        var presenter = ListPresenter()
        return presenter
    }

    @Provides
    fun provideDetalPresenter(view: DetailContract.View): DetailContract.Presenter {
        var presenter = DetailPresenter()
        return presenter

    }
}