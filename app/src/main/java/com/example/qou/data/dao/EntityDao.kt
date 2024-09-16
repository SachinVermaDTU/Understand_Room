package com.example.qou.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.qou.data.model.Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityDao {

    @Query("Select * from Qoute_table")
     fun getData(): Flow<List<Entity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertAll(items: List<Entity>)
}