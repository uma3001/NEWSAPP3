package com.example.newsapp

data class DataItem(
    var articles:ArrayList<Articles> = arrayListOf()
)

class Articles {
    var title: String? = null
    var author: String? = null
}
