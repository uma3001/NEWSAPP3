package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: News, val exampleList: List<Articles>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
        var title :TextView = itemView.findViewById(R.id.tittle)
        var author :TextView = itemView.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false)
        return ViewHolder(itemView)
    }
    override fun getItemCount() = exampleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = exampleList[position].title
        holder.author.text = exampleList[position].author

    }
}