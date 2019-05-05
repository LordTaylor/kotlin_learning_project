package com.acante.kotlinsecretproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.ListFragment
import com.acante.kotlinsecretproject.ui.login.LoginFragment
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {


    lateinit var presenter: MainPresenter

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter.attache(this)

        injectDependency()

    }

    private fun injectDependency() {

    }


    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                ListFragment()
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
    override fun showLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_view,
                LoginFragment()
            )
            .commit()
    }
}
