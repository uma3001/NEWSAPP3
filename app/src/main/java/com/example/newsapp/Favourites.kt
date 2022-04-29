package com.example.newsapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Favourites() : AppCompatActivity(){

    //var recyclerview: RecyclerView?=null
    //lateinit var Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        //var Tvtitle: TextView = findViewById(R.id.tittle)
        //var Tvauthor: TextView = findViewById(R.id.author)
        //var listitem = emptyList<DataItem>()

        //recyclerview = findViewById(R.id.recyclerview)
       // recyclerview?.layoutManager = LinearLayoutManager(this)
       // recyclerview?.setHasFixedSize(true)

        //recyclerview?.setAdapter(Adapter)

        val bundle = intent.extras

        val title = bundle!!.getString("tittle","null")
        val author = bundle!!.getString("author","null")
        Toast.makeText(this,title + " "+author,Toast.LENGTH_SHORT).show()

        //Tvtitle.setText("$title")
       // Tvauthor.setText("$author")



        }
}