package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://newsapi.org/"
class News : AppCompatActivity() {

    lateinit var Adapter: Adapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var recyclerview:RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        recyclerview = findViewById(R.id.recyclerview)
        val exampleList = DummyList()
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.setHasFixedSize(true)

        getdata()
    }

    private fun getdata() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Articles>?> {
            override fun onResponse(
                call: Call<List<Articles>?>,
                response: Response<List<Articles>?>
            ) {
                val responseBody = response.body()!!

                Adapter = Adapter(baseContext,responseBody)
                Adapter.notifyDataSetChanged()
                recyclerview?.adapter = Adapter
            }

            override fun onFailure(call: Call<List<Articles>?>, t: Throwable) {
                Log.d("News","onFailure: "+t.message)
            }
        })
    }

    private fun DummyList(): List<Row_items> {
        val list = ArrayList<Row_items>()
        list.add(Row_items(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Row_items(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Row_items(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Row_items(R.drawable.ic_baseline_menu_book_24," "," "))
        list.add(Row_items(R.drawable.ic_baseline_menu_book_24," "," "))

        return list
    }
}