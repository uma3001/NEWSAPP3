package com.example.newsapp


import android.os.Bundle
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
        var FavList = dummyList()
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.setHasFixedSize(true)
        val Favadapter = Favo_Adapter(this,ArrayList<Articles>())
        recyclerview?.adapter = Favadapter

        //favviewModel.showfavo(Articles(id = 1, title = "", author = ""))

        favviewModel.allfavo.observe(this,{Articles ->
            Favadapter.add(ArrayList(Articles))})

        Favadapter?.notifyDataSetChanged()
    }

     private fun dummyList(): ArrayList<Item> {
        val list = ArrayList<Item>()
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," ","" ))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Item(R.drawable.ic_baseline_menu_book_24," "," "))

        return list
    }

}