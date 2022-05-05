package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.Int

class Adapter(val context: News,val exampleList: List<Articles>, private var callbackinterface: Callbackinterface):RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(itemView: View,callbackinterface: Callbackinterface) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tittle)
        var author: TextView = itemView.findViewById(R.id.author)
        var favcheck: CheckBox = itemView.findViewById(R.id.checkfav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false)

        return ViewHolder(itemView,callbackinterface)
    }

    override fun getItemCount() = exampleList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = exampleList[position].title
        holder.author.text = exampleList[position].author

            holder.favcheck.setOnCheckedChangeListener { checkbox, ischecked ->
                if (ischecked) {
                    holder.title.text = exampleList[position].title
                    holder.author.text = exampleList[position].author
                        callbackinterface.Passdata(Tittle = holder.title.toString(),Author = holder.author.toString())

                } else {
                   // removefromfav()
                }
            }
    }
    /*fun addtofav() {
        favViewModel.addfavo(dataitem = Articles(id = 1, title = "", author = ""))

    }
    fun removefromfav(){
        favViewModel.deletefavo(dataitem = Articles(id = 1, title = "", author = ""))

    }*/

    interface Callbackinterface {
        fun Passdata(Tittle:String,Author:String)


    }
}
