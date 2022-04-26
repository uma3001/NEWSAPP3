package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/everything?q=tesla&from=2022-04-23&sortBy=publishedAt&apiKey=fd25b2019ab5471ca5ce2641d0d8cfae")
    fun getData(): Call<DataItem>
}
