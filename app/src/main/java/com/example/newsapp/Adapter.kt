package com.example.newsapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback



class Adapter(val context: News, val exampleList: List<Articles>, var listener: OnItemClickListener):RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tittle)
        var author: TextView = itemView.findViewById(R.id.author)
        var favcheck: CheckBox = itemView.findViewById(R.id.checkfav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = exampleList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = exampleList[position].title
        holder.author.text = exampleList[position].author

        holder.itemView.setOnClickListener(View.OnClickListener {

            listener.onItemClick(exampleList[position].title,exampleList[position].author,position)
            holder.favcheck.setOnCheckedChangeListener { checkbox, ischecked ->
                if (ischecked) {
                    //Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show()


                } else {
                    // Toast.makeText(this, "Removed from favourites", Toast.LENGTH_SHORT).show()

                }

            }

        })
        //CheckBox cb = (CheckBox)convertView.findViewById(R.id.check_box);
        //  if(getSelectedItemPosition() == position)
        //     cb.setChecked(true);
        //  else
        //     cb.setChecked(true);
        // }

    }

    interface OnItemClickListener {

        fun onItemClick(
            Tittle:String,
            Author:String,
            Position:Int
        )
    }
}
