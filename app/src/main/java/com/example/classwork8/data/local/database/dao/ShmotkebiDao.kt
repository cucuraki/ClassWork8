package com.example.classwork8.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.classwork8.data.local.database.entyties.Shmotka
import kotlinx.coroutines.flow.Flow

@Dao
interface ShmotkebiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShmotkebi(vararg shmotkebi: Shmotka)

    @Query("SELECT * from shmotka_table")
    fun readAllDate(): Flow<List<Shmotka>>

    @Query("Delete from shmotka_table")
    suspend fun deleteAll()

}