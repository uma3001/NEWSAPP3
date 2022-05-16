package com.example.newsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

@Entity
class Articles(
    @PrimaryKey var id : Int =1,
    var title: String ="",
    var author: String=""
)

