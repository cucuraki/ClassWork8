package com.example.classwork8.data.local.repositorys

import com.example.classwork8.data.local.database.dao.ShmotkebiDao
import com.example.classwork8.data.local.database.entyties.Shmotka
import com.example.classwork8.domain.repositorys.GetShmotkebiDBRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShmotkebiLocalRepoImpl @Inject constructor(private val dao: ShmotkebiDao): GetShmotkebiDBRepo {
    override fun getShmotkebi(): Flow<List<Shmotka>> = dao.readAllDate()
    override suspend fun insertShmotka(vararg shmotkebi: Shmotka) = dao.addShmotkebi(*shmotkebi)
    override suspend fun delete() {
        dao.deleteAll()
    }
}