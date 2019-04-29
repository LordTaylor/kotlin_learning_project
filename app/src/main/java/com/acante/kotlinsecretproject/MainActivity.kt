package com.acante.kotlinsecretproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acante.kotlinsecretproject.ui.base.BaseActivity
import com.acante.kotlinsecretproject.ui.detail.DetailFragment
import com.acante.kotlinsecretproject.ui.list.MovieListFragment
import com.acante.kotlinsecretproject.ui.main.MainContract
import com.acante.kotlinsecretproject.ui.main.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {


    lateinit var presenter:MainPresenter

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter.attache(this)

        injectDependency()

//        var applicationComponent:ApplicationComponent = DaggerApplicationComponent.builder().build();

//        movieAdapter=MovieAdapter()
//        container_view.layoutManager = LinearLayoutManager(this)
//        container_view.adapter = movieAdapter
//
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//        val movieData = retrofit.create(RequestInterface::class.java)
//        movieData.getData()
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
////                    var data:List<MovieData> = it
//                    movieAdapter.setMovies(it!!)
//
//                }, {
//                    Log.d(TAG,it.message);
//                    Toast.makeText(applicationContext,it.message,Toast.LENGTH_LONG).show()
//                }
//            )

    }

    private fun injectDependency() {

    }


    override fun showListFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container_view,
            MovieListFragment()
        ).commit()
    }

    override fun showDetailFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container_view,
            DetailFragment()
        ).commit()
    }
}
