package com.example.classwork8.domain.repositorys

import com.example.classwork8.common.responsestate.ResponseState
import com.example.classwork8.data.remote.dtos.ShmotkaDto

interface ShmotkepiRepository {
    suspend fun getShmotkebi(): ResponseState<List<ShmotkaDto>>
}