package com.example.classwork8.data.local.database

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.classwork8.data.local.database.dao.ShmotkebiDao
import com.example.classwork8.data.local.database.entyties.Shmotka

@Database(entities = [Shmotka::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun shnotkaDao(): ShmotkebiDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "data_base"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}