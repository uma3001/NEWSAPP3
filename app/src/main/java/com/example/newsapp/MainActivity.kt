package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivicon = findViewById<ImageView>(R.id.ivicon)
        ivicon.alpha = 0f
        ivicon.animate().setDuration(1500).alpha(1f).withEndAction{
            retrive()
        }
    }
    fun retrive() {
        sharedPref = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val email = sharedPref.getString("EMAIL","")
        val password = sharedPref.getString("PASSWORD","")

        if(email != null && password != null) {
            val intent = Intent(this, News::class.java)
            startActivity(intent)
            finish()
        }
        else {
            val i = Intent(this,login::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}