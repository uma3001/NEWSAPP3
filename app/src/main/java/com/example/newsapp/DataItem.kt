package com.example.newsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

class Articles {
    @PrimaryKey var title: String? = null
    var author: String? = null
}
