package com.example.newsapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication :Application(){

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { FavoDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { FavoRepositry(database.itemDao()) }

}