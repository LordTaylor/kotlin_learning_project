package com.acante.kotlinsecretproject

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.ListFragment
import com.acante.kotlinsecretproject.ui.login.LoginFragment
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter
import com.acante.kotlinsecretproject.ui.register.RegisterFragment
import com.acante.kotlinsecretproject.utils.Constance

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
    override fun getUserEmail(){
        val sp = getSharedPreferences(Constance.PREF_NAME, Context.MODE_PRIVATE)
        val name = sp.getString(Constance.USER_EMAIL,"")
        showListFragment()
//        if(name.trim().isEmpty()){
//            showRegistreFragment()
//            return
//        }else{
//            showLoginFragment(name)
//        }
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
