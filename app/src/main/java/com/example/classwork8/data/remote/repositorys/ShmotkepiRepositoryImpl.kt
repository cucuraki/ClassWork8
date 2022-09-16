package com.example.classwork8.data.remote.repositorys

import com.example.classwork8.common.responsestate.ResponseState
import com.example.classwork8.data.remote.apis.ShmotkebiApi
import com.example.classwork8.data.remote.dtos.ShmotkaDto
import com.example.classwork8.domain.repositorys.ShmotkepiRepository
import javax.inject.Inject

class ShmotkepiRepositoryImpl @Inject constructor(private val api: ShmotkebiApi) :
    ShmotkepiRepository {
    override suspend fun getShmotkebi(): ResponseState<List<ShmotkaDto>> {
        return try {
            val response = api.getShmotkebi()
            if (response.isSuccessful)
                ResponseState.Success(response.body()!!)
            else
                ResponseState.Error(response.errorBody()!!.string())
        } catch (e: Exception) {
            ResponseState.Error(e.toString())
        }
    }
}