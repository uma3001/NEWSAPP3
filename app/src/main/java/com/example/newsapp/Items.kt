package com.example.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class Item(
    var articles:ArrayList<Articles> = arrayListOf()
)

class Article {
     var title: String? = null
    var author: String? = null
}



