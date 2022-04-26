package com.example.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName="Articles")
data class Items(
   // @PrimaryKey var title: String,
    var author: String,
    var image: String)



