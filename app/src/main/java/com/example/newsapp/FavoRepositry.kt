package com.example.newsapp

import androidx.lifecycle.LiveData

class FavoRepositry( val itemDao: ItemDao) {

    var allfavlist: LiveData<List<Articles>> = itemDao.getdata()

    suspend fun insert(dataitem:Articles){
        itemDao.insert(dataitem)
    }
    suspend fun delete(dataitem:Articles){
        itemDao.delete(dataitem)
    }
    //fun getdata(){
    //   itemDao.getdata()
   //}
}
