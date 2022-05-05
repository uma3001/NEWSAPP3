package com.example.newsapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    //@Query("SELECT * FROM Articles")
    //fun getdata(dataitem: Articles):List<Articles>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataItem: Articles)

    @Delete
    suspend fun delete(dataitem: Articles)
}