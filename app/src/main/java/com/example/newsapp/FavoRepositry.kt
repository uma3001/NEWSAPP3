package com.example.newsapp

import kotlinx.coroutines.flow.Flow


class FavoRepositry(private val itemDao: ItemDao) {

    //val allfavlist: Flow<List<Articles>> = itemDao.getall()

    suspend fun insert(dataitem:Articles){
        itemDao.insert(dataitem)
    }
    suspend fun delete(dataitem:Articles){
        itemDao.delete(dataitem)
    }
    //suspend fun getdata(dataitem:Articles) {
    //    itemDao.getdata(dataitem)
   // }
}
