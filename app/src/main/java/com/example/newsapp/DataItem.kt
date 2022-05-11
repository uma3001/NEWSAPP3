package com.example.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

@Entity
class Articles(
    @PrimaryKey var id : Int =1,
    @ColumnInfo(name = "TITTLE") var title: String ="",
    @ColumnInfo(name = "AUTHOR")var author: String=""
)

