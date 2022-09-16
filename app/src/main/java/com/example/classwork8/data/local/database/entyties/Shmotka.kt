package com.example.classwork8.data.local.database.entyties

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shmotka_table")
data class Shmotka(
    val title: String,
    val cover: String,
    val price: String,
    val liked: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)