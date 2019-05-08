package com.acante.kotlinsecretproject.ui.detail

import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import javax.inject.Inject

class DetailPresenter @Inject constructor(): DetailContract.Presenter {
    lateinit var view : DetailContract.View
    lateinit var repo: Repo
    override fun attache(view: DetailContract.View,activity: BaseActivity) {
        this.view= view
        repo=activity.getMyRepo()
    }
}