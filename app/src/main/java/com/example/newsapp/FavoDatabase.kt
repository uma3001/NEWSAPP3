package com.example.newsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ Items::class], version = 1)
abstract class FavoDatabase: RoomDatabase() {

    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile
        private var INSTANCE: FavoDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope):FavoDatabase
        {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoDatabase::class.java,
                    "Favo_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(FavoCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
    private class FavoCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.itemDao())
                }
            }
        }

        suspend fun populateDatabase(itemDao: ItemDao) {
            itemDao.delete()
        }
    }
}
