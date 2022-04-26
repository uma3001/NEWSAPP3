package com.example.newsapp

import androidx.annotation.WorkerThread

class FavoRepositry(private val itemDao: ItemDao) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dataitem:DataItem){
        itemDao.insert(dataitem)
    }
}
//val currentnumber:MutableLiveData<Int> by lazy {
//        MutableLiveData<Int>()
//    val allWords: Flow<List<Items>> = itemDao.getAlphabetizedWords()