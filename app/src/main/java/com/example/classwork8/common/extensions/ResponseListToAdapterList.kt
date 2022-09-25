package com.example.classwork8.common.extensions

import com.example.classwork8.data.local.database.entyties.Shmotka
import com.example.classwork8.data.remote.dtos.ShmotkaDto
import com.example.classwork8.domain.models.ShmotkebiModel

fun List<ShmotkaDto>.toAdapterList(): List<ShmotkebiModel> = this.mapIndexed() { position, it ->
    ShmotkebiModel(
        it.title,
        it.cover,
        it.price,
        it.liked,
        position
    )
}

fun List<Shmotka>.localToAdapterList(): List<ShmotkebiModel> = this.mapIndexed() { position, it ->
    ShmotkebiModel(
        it.title,
        it.cover,
        it.price,
        it.liked,
        position
    )
}

fun List<ShmotkebiModel>.remoteToLocalList(): List<Shmotka> = this.mapIndexed() { position, it ->
    Shmotka(
        it.title,
        it.cover,
        it.price,
        it.liked,
        position
    )
}
