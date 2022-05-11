package com.example.newsapp

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


class FavoRepositry( val itemDao: ItemDao) {

    //val allfavlist: Flow<MutableList<Articles>> = ItemDao.getdata()

    suspend fun insert(dataitem:Articles){
        itemDao.insert(dataitem)
    }
    suspend fun delete(dataitem:Articles){
        itemDao.delete(dataitem)
    }
    fun getdata(){
       itemDao.getdata()
   }
}
