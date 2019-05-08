package com.acante.kotlinsecretproject

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acante.kotlinsecretproject.di.component.DaggerFragmentComponent
import com.acante.kotlinsecretproject.di.component.DaggerRepoComponent
import com.acante.kotlinsecretproject.di.component.RepoComponent
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.MyListFragment
import com.acante.kotlinsecretproject.ui.login.LoginFragment
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter
import com.acante.kotlinsecretproject.ui.register.RegisterFragment
import com.acante.kotlinsecretproject.utils.Constance
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {


    lateinit var presenter: MainPresenter

    val TAG: String = "MainActivity"

    @Inject
    lateinit var repo: Repo

    override fun getMyRepo(): Repo {
        return repo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repo = Repo.INSTANCE
        presenter = MainPresenter()
        presenter.attache(this,this)


    }
    override fun getUserEmail(){
        val sp = getSharedPreferences(Constance.PREF_NAME, Context.MODE_PRIVATE)
        val name = sp.getString(Constance.USER_EMAIL,"")
        if(name.trim().isEmpty()){
            showRegistreFragment()
            return
        }else{
            showLoginFragment(name)
        }
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                MyListFragment()
            )
            .commit()
    }

    override fun showDetailFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                DetailFragment()
            )
            .commit()
    }
    override fun showLoginFragment(email:String) {
        val fragment:LoginFragment = LoginFragment.instance
            fragment.setEmail(email)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                fragment
            )
            .commit()
    }

    override fun showRegistreFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                RegisterFragment()
            )
            .commit()
    }
}
