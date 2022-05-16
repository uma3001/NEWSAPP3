package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Favo_Adapter(val context:Context,val dummyList: ArrayList<Articles>) : RecyclerView.Adapter<Favo_Adapter.FavoViewHolder>() {

    class FavoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var favtittle: TextView = itemView.findViewById(R.id.favtittle)
        var favauthor: TextView = itemView.findViewById(R.id.favauthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoViewHolder {
        val itemViewrecycler = LayoutInflater.from(context).inflate(R.layout.fav_recycler_view,parent,false)
        return FavoViewHolder(itemViewrecycler)
    }

    override fun getItemCount() = dummyList.size

    override fun onBindViewHolder(holder: FavoViewHolder, position: Int) {
        holder.favtittle.text = dummyList[position].title
        holder.favauthor.text = dummyList[position].author
    }
    fun add(articles: ArrayList<Articles>?) {
        if (articles != null) {
            dummyList.addAll(articles)
        }
        notifyDataSetChanged()
    }
}