package com.acante.kotlinsecretproject.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter

abstract class BaseActivity : AppCompatActivity(){

    abstract fun getMyRepo(): Repo

}