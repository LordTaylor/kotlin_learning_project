package com.acante.kotlinsecretproject.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.di.component.DaggerRepoComponent
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.repo.model.RepoAccess.Repo
import javax.inject.Inject

class ListAdapter(val context: Context) : RecyclerView.Adapter<ListAdapter.DataViewHolder>() {


    private val movieList: MutableSet<MovieData> = mutableSetOf<MovieData>()
    lateinit var listener: OnClickListener
    //     lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    fun getItem(position:Int):MovieData{
        return movieList.elementAt(position)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.onBind(position)
//        holder.setOnClickListener()
    }

    fun setMovies(data: Set<MovieData>) {
        movieList.addAll(data)
        notifyDataSetChanged()
    }
    fun setOnItemClickListener(listener: OnClickListener){
        injectDependency()
        this.listener= listener
    }
    fun injectDependency(){
        var repoComponent = DaggerRepoComponent.create()
        repoComponent.inject(this)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var view: View = itemView
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var movieCategory: TextView = itemView.findViewById(R.id.movie_description)
        var movieAvatar: ImageView = itemView.findViewById(R.id.movie_avatar)

        fun onBind(id:Int) {
            title.text = movieList.elementAt(id).title
            movieCategory.text = movieList.elementAt(id).year
            view.setOnClickListener({
                listener.onClick(view,adapterPosition)
            })
//                Picasso.get().load(item.poster).into(movieAvatar)

        }
    }

    interface OnClickListener {

        fun onClick(view: View, position: Int)

    }

}