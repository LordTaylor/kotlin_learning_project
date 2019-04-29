package com.acante.kotlinsecretproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.mvptry.base.ui.base.BaseContact
import com.acante.kotlinsecretproject.ui.main.MainFragment

class MainActivity : AppCompatActivity(), BaseContact.View {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container_view,MainFragment()).commit()

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


}
