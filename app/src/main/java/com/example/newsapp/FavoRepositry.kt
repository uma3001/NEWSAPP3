package com.example.newsapp

import kotlinx.coroutines.flow.Flow


class FavoRepositry(private val itemDao: ItemDao) {

    val allfavlist: Flow<List<DataItem>> = ItemDao.getall()

    suspend fun insert(dataitem:DataItem){
        itemDao.insert(dataitem)
    }
    suspend fun delete(dataitem:DataItem){
        itemDao.delete(dataitem)
    }
    fun getall(dataitem:DataItem){
        itemDao.getall()
    }
}
