package com.acante.kotlinsecretproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.api.Session
import com.acante.kotlinsecretproject.di.component.DaggerFragmentComponent
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class MyListFragment : Fragment(), ListContract.View, ListAdapter.OnClickListener {

    @Inject
    lateinit var presenter: ListPresenter
    lateinit var listAdapter: ListAdapter
    lateinit var rootView: View
    private lateinit var session: Session

    override fun onClick(view: View, position: Int) {
        showDetailFragment(position)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
//        rootView.setOnClickListener(this)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        dependencyInjection()
        presenter.attache(this)
        presenter.addSession(session)
        presenter.loadData()//sendData(MovieData(1,"a","a"))
//        ViewModelProvider.
        presenter.loadSimpleText("tak")
        listAdapter.setOnItemClickListener(this)

    }

    private fun initView() {
        activity!!.setTitle(R.string.list_fragment_title)
        list_botomNavigation.inflateMenu(R.menu.bottom_navigation)
        list_container.setLayoutManager(LinearLayoutManager(context))
        listAdapter = ListAdapter(this!!.context!!)
        listAdapter.setOnItemClickListener(this)
        list_container.adapter = listAdapter
    }


    override fun dataLoaded(data: List<MovieData>) {
        listAdapter.setMovies(data.toSet())
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
        activity!!.setTitle(listAdapter.itemCount.toString())
    }

    override fun showDetailFragment(position: Int) {
        val fragment = DetailFragment.instance
        fragment.setEditItem(listAdapter.getItem(position))
        fragmentManager!!.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
            .replace(
                R.id.container_view,
                fragment
            )
            .commit()
    }

    fun setSession(session: Session) {
        this.session = session
    }

    companion object {
        val INSTANCE: MyListFragment = MyListFragment()
    }
}