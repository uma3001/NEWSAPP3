package com.example.newsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

@Entity
class Articles {
    @PrimaryKey val title: String,
    var author: String? = null
}
