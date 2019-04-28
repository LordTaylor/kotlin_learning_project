package com.acante.kotlinsecretproject.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acante.kotlinsecretproject.R
import kotlinx.android.synthetic.main.item_view.view.*
import android.graphics.Color

class DataAdapter(private val dataList : ArrayList<Android>, private val listener:Listener):RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    interface Listener {

        fun onItemClick(android : Android)
    }

    private val colors : Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(android: Android, listener: Listener, colors : Array<String>, position: Int) {

            itemView.movie_title.text = android.name
            itemView.movie_description.text = android.version
            itemView.tv_api_level.text = android.apiLevel
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))

            itemView.setOnClickListener{ listener.onItemClick(android) }
        }
    }
}