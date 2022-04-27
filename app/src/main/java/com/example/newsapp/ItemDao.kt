package com.example.newsapp

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM DataItem")
    fun getall(dataitem: DataItem):LiveData<List<DataItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataItem: DataItem)

    @Delete
    suspend fun delete(dataitem: DataItem)
}