package com.acante.kotlinsecretproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.mvptry.base.BaseApplication
import com.acante.kotlinsecretproject.mvptry.base.di.component.ApplicationComponent
import com.acante.kotlinsecretproject.di.component.DaggerApplicationComponent
import com.acante.kotlinsecretproject.mvptry.base.di.module.ActivityBindingModule
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.rest.RequestInterface
import com.acante.kotlinsecretproject.mvptry.base.ui.base.BaseContact
import com.acante.kotlinsecretproject.mvptry.base.ui.main.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BaseContact.View {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    inner class MovieAdapter : RecyclerView.Adapter<MovieAdapter.DataViewHolder>() {
        private val movieList: MutableList<MovieData> = mutableListOf()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
            return DataViewHolder(layoutInflater.inflate(R.layout.item_view, parent, false))
        }

        override fun getItemCount(): Int {
            return movieList.size
        }

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.onBind(movieList[position])
        }

        fun setMovies(data: List<MovieData>) {
            movieList.addAll(data)
            notifyDataSetChanged()
        }

        inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var title: TextView = itemView.findViewById(R.id.movie_title)
            var movieCategory: TextView = itemView.findViewById(R.id.movie_description)
            var movieAvatar: ImageView = itemView.findViewById(R.id.movie_avatar)

            fun onBind(item: MovieData) {

                title.text = item.title
                movieCategory.text = item.year
//                Picasso.get().load(item.poster).into(movieAvatar)

            }


        }

    }
}
