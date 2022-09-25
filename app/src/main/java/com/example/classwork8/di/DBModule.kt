package com.example.classwork8.di

import android.content.Context
import androidx.room.Room
import com.example.classwork8.data.local.database.DataBase
import com.example.classwork8.data.local.database.dao.ShmotkebiDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): DataBase = Room.databaseBuilder(
        context,
        DataBase::class.java,
        "shmotkebi_db"
    ).build()

    @Provides
    @Singleton
    fun getDao(db: DataBase): ShmotkebiDao = db.shmotkaDao()

}