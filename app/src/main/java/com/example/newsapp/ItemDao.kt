package com.example.newsapp

import android.content.ClipData
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataItem: DataItem)

    @Delete
    suspend fun delete()
}