package com.example.classwork8.data.local.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.classwork8.data.local.database.dao.ShmotkebiDao
import com.example.classwork8.data.local.database.entyties.Shmotka

@Database(entities = [Shmotka::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun shmotkaDao(): ShmotkebiDao
}