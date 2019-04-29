package com.acante.kotlinsecretproject.di.module

import com.acante.kotlinsecretproject.ui.detail.DetailContract
import com.acante.kotlinsecretproject.ui.detail.DetailPresenter
import com.acante.kotlinsecretproject.ui.list.ListContract
import com.acante.kotlinsecretproject.ui.list.ListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class FragmentModule {

    @Provides
     fun provideListPresenter(view:ListContract.View):ListPresenter{
        var presenter = ListPresenter()
        presenter.attache(view)
        return presenter
    }

    @Provides
      fun provideDetalPresenter(view:DetailContract.View):DetailPresenter{
        var presenter = DetailPresenter()
        presenter.attache(view)
        return presenter

    }
}