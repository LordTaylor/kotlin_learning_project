package com.acante.kotlinsecretproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.di.component.DaggerFragmentComponent
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(), ListContract.View, ListAdapter.OnClickListener {

    @Inject
    lateinit var presenter: ListPresenter
    lateinit var listAdapter: ListAdapter
    lateinit var rootView: View

    override fun onClick(view: View) {
        presenter.loadData()
        presenter.sendData(MovieData(666, "takkk", "nieee"))
        Toast.makeText(context, "AAAAAAAAAAAAAAAAAA", Toast.LENGTH_LONG).show()


    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        rootView.setOnClickListener(this)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        dependencyInjection()
        presenter.attache(this)
        presenter.loadData()//sendData(MovieData(1,"a","a"))
//        ViewModelProvider.

    }

    private fun initView() {
        activity!!.setTitle(R.string.list_fragment_title)
        list_botomNavigation.inflateMenu(R.menu.bottom_navigation)
        list_container.setLayoutManager(LinearLayoutManager(context))
        listAdapter = ListAdapter(this!!.context!!, this)
        list_container.adapter = listAdapter
    }


    override fun dataLoaded(data: List<MovieData>) {
        listAdapter.setMovies(data)
    }

    fun dependencyInjection() {
        var fragmentComponent = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        fragmentComponent.inject(this)
    }

    override fun editItem(id: Int) {
        fragmentManager!!.beginTransaction()
            .replace(R.id.container_view, DetailFragment())
            .commit()
    }

    override fun addItem() {
        fragmentManager!!.beginTransaction()
            .replace(R.id.container_view, DetailFragment())
            .commit()
    }

    override fun setTitle(title: String) {
        activity!!.setTitle(title)
    }
}