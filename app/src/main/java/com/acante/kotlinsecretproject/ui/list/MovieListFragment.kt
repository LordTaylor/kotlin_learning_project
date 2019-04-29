package com.acante.kotlinsecretproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.utils.Constance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieListFragment : Fragment(), ListContract.View {


    lateinit var presenter: ListPresenter
    lateinit var listAdapter: ListAdapter
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListPresenter()
        presenter.attache(this)
        presenter.loadData()
        initView()
    }

    private fun initView() {
        list_container.setLayoutManager(LinearLayoutManager(context))
        listAdapter = ListAdapter(this!!.context!!)
        list_container.adapter = listAdapter
    }


    override fun dataLoaded(data: List<MovieData>) {
        listAdapter.setMovies(data)
    }


}