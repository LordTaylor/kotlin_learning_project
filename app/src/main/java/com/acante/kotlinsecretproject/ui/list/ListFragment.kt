package com.acante.kotlinsecretproject.ui.list


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.di.component.DaggerFragmentComponent
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.DetailsViewModel
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.utils.SwipeToDelete
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment: Fragment(), ListContract.View, ListAdapter.onItemClickListener {


    @Inject lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    lateinit var recyclerView : RecyclerView
    lateinit var progressBar : ProgressBar

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_list, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerView)
        progressBar = rootView.findViewById(R.id.progressBar)
        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attache(this)
        presenter.subscribe()
        initView()
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }



    private fun initView() {
        presenter.loadData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccsess(list: List<MovieData>) {


        recyclerView.layoutManager =LinearLayoutManager(activity)
        recyclerView.adapter = ListAdapter(activity!!,list.toMutableList(),this)

        val swipeHandler = object : SwipeToDelete(activity!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as ListAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }



    companion object {
        val TAG: String = "ListFragment"
    }

    override fun itemDetail(postId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadDataAllSuccsess(model: DetailsViewModel) {
        print(model.toJson())
    }

    override fun itemRemoveClick(post: MovieData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}