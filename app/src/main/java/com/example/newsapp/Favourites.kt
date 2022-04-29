package com.example.newsapp

import android.os.Bundle
import android.text.format.DateFormat
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Favourites() : AppCompatActivity(){

    lateinit var recyclerview: RecyclerView
    lateinit var Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        /*val dateFormat = DateFormat.getDateFormat(
            applicationContext
        )*/

        val Tvtitle: TextView = findViewById(R.id.favtittle)
        val Tvauthor: TextView = findViewById(R.id.favauthor)
        recyclerview = findViewById(R.id.fav_recyclerview)
        var listitem = emptyList<DataItem>()


        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.setHasFixedSize(true)

        recyclerview?.setAdapter(Adapter)

        val bundle = intent.extras

        val title = bundle?.getString("tittle","null")
        val author = bundle?.getString("author","null")
        Toast.makeText(this,title + " "+author,Toast.LENGTH_SHORT).show()


       // Tvtitle.setText(title)
       // Tvauthor.setText(author)



        }
}