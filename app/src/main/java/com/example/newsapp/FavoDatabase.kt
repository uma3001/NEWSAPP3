package com.example.newsapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [ Articles::class], version = 1)
abstract class FavoDatabase(): RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: FavoDatabase? = null
        fun getDatabase(context: Context, applicationScope: CoroutineScope): FavoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoDatabase::class.java,
                    "Favo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
