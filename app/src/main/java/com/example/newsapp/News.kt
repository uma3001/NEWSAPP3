package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    var favoriteDatabase: FavoDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        var btnfav = findViewById<Button>(R.id.favbtn)

        recyclerview = findViewById(R.id.recyclerview)
        val exampleList = DummyList()
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.setHasFixedSize(true)

        btnfav.setOnClickListener {
            val intent = Intent(this,Favourites::class.java)
            startActivity(intent)
        }
        getdata()
    }

    private fun getdata() {
        val httpLoggingInterceptor = HttpLoggingInterceptor ()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient: OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofitBuilder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<DataItem> {
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {

                Adapter =  Adapter(this@News, response.body()?.articles!!)
                recyclerview?.setAdapter(Adapter)
                Adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                TODO("Not yet implemented")
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