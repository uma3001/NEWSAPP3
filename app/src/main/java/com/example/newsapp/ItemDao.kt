package com.example.newsapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM DataItem")
    fun getall():Flow<List<DataItem>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataItem: DataItem)

    @Delete
    suspend fun delete(dataitem: DataItem)
}