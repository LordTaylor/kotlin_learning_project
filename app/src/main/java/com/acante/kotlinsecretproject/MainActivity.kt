package com.acante.kotlinsecretproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.acante.kotlinsecretproject.di.component.DaggerActivityComponent
import com.acante.kotlinsecretproject.di.module.ActivityModule
import com.acante.kotlinsecretproject.ui.list.ListFragment
import com.acante.kotlinsecretproject.ui.main.MainContract
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG: String = "MainActivity"

    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        injectDependency()

        presenter.attache(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_option_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when(item!!.itemId){
//            R.id.
//        }
showListFragment()
        return super.onOptionsItemSelected(item)
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.container_view, ListFragment().newInstance(), ListFragment.TAG)
            .commit()

    }

    override fun showAboutFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build()
        activityComponent.inject(this)
    }
}
