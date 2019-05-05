package com.acante.kotlinsecretproject.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.repo.model.MovieData

 class ListAdapter(val context: Context,val listener:OnClickListener) : RecyclerView.Adapter<ListAdapter.DataViewHolder>() {
    private val movieList: MutableList<MovieData> = mutableListOf()
//     lateinit var context:Context
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.onBind(movieList[position],listener)
        holder.movieAvatar.setOnClickListener(listener)
    }

    fun setMovies(data: List<MovieData>) {
        movieList.addAll(data)
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var movieCategory: TextView = itemView.findViewById(R.id.movie_description)
        var movieAvatar: ImageView = itemView.findViewById(R.id.movie_avatar)
        lateinit var listener:ListAdapter.OnClickListener

        fun onBind(item: MovieData,listener: OnClickListener) {
            title.text = item.title
            movieCategory.text = item.year
            this.listener= listener
//                Picasso.get().load(item.poster).into(movieAvatar)
        }

    }

     interface OnClickListener : View.OnClickListener{

         override fun onClick(view:View)

     }

 }