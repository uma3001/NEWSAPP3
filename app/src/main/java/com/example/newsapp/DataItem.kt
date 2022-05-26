package com.example.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

@Entity
class Articles(
    @PrimaryKey(autoGenerate = true) var id : Int= 0,
    @ColumnInfo(name = "Tittle") var title: String ="",
    @ColumnInfo(name = "Author") var author: String=""
)