package com.example.classwork8.domain.repositorys

import com.example.classwork8.data.local.database.entyties.Shmotka
import kotlinx.coroutines.flow.Flow

interface GetShmotkebiDBRepo {
    fun getShmotkebi(): Flow<List<Shmotka>>
    suspend fun insertShmotka(vararg shmotkebi: Shmotka)
    suspend fun delete()
}