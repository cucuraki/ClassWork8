package com.example.classwork8.extensions

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