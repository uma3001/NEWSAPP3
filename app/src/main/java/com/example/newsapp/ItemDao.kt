package com.example.newsapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {

    @Query("SELECT * FROM Articles")
    fun getdata() : LiveData<MutableList<Articles>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataItem: Articles)

    @Delete
    suspend fun delete(dataitem: Articles)
}