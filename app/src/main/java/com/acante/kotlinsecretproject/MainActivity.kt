package com.acante.kotlinsecretproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.di.component.DaggerApplicationComponent
import com.acante.kotlinsecretproject.di.module.ActivityModule
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.ui.base.BaseContact
import com.acante.kotlinsecretproject.ui.main.MainContract
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BaseContact.View {

    private val TAG: String = "MainActivity"

    @Inject
    lateinit var presenter: MainContract.Presenter


    lateinit var containerRecycler: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        containerRecycler = findViewById(R.id.container_view)

        injectDependency()

        presenter.attache(this)
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
//        val movieData = retrofit.create(ApiServiceInterface::class.java)
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
        val activityComponent = DaggerApplicationComponent.builder().activityBindingModule(ActivityModule(this)).build()
//        activityComponent.buildActivity(this)
//        activityComponent.inject(this.application as BaseApplication)
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
