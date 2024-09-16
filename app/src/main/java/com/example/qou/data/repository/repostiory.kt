package com.example.qou.data.repository

import com.example.qou.data.dao.EntityDao
import com.example.qou.data.model.Entity
import kotlinx.coroutines.flow.Flow

interface repostiory {
    suspend fun getDat(): Flow<List<Entity>>
}