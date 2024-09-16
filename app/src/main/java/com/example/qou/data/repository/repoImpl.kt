package com.example.qou.data.repository

import com.example.qou.data.dao.EntityDao
import com.example.qou.data.model.Entity
import kotlinx.coroutines.flow.Flow

class repoImpl: repostiory{
    override suspend fun getDat(): Flow<List<Entity>> {
        TODO("Not yet implemented")
    }

}