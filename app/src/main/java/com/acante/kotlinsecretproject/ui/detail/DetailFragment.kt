package com.acante.kotlinsecretproject.ui.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.di.component.DaggerFragmentComponent
import com.acante.kotlinsecretproject.di.module.FragmentModule
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.list.MyListFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment : Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    private fun dependencyInjection() {

        var fragmentComponent = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        fragmentComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        dependencyInjection()
    }

    private fun initView() {
        detail_cancle.setOnClickListener(View.OnClickListener {
            var fragment = MyListFragment.INSTANCE
            fragmentManager!!.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                .replace(R.id.container_view, fragment)
                .commit()
            Toast.makeText(context, "Detail view on click", Toast.LENGTH_LONG).show()
        })

    }

    fun setEditItem(movieData: MovieData) {

    }

    companion object {
        val instance: DetailFragment = DetailFragment()
    }

}
