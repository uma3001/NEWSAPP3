package com.example.newsapp

import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Favourites_Activity() : AppCompatActivity(){

    var recyclerview: RecyclerView?=null

    private val favviewModel:FavouritesViewModel by viewModels  {
        FavouritesViewModel.FavouritesViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        recyclerview = findViewById(R.id.fav_recyclerview)
        val FavList = dummyList()
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.setHasFixedSize(true)

        val Favadapter = Favo_Adapter(this,ArrayList<Articles>())
        recyclerview?.adapter = Favadapter
        
        favviewModel.showfavo(Articles())
    }

    private fun dummyList(): List<Item> {
        val list = ArrayList<Item>()
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))

        return list
    }

}