package com.example.qou.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "Qoute_table")
data class Entity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val author: String,
    val description: String
)
