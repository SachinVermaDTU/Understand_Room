package com.example.qou.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.qou.data.dao.EntityDao
import com.example.qou.data.model.Entity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Entity::class], version = 1)
abstract class database : RoomDatabase() {

    abstract fun entityDao(): EntityDao

    companion object {
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context: Context): database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                Log.d("preberrgr", "ho toh rha hai database")
               return instance
            }
        }
    }



    suspend fun prepopulateDatabase(context: Context, db: database) {
        val jsonString = loadJsonFromAsset(context, "quo.json")
        val listType = object : TypeToken<List<Entity>>() {}.type
        val userList: List<Entity> = Gson().fromJson(jsonString, listType)
        db.entityDao().insertAll(userList)
    }

    fun loadJsonFromAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}
