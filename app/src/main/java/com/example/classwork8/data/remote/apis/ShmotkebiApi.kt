package com.example.classwork8.data.remote.apis

import com.example.classwork8.data.remote.dtos.ShmotkaDto
import retrofit2.Response
import retrofit2.http.GET

interface ShmotkebiApi {
    @GET("v3/05d71804-4628-4269-ac03-f86e9960a0bb")
    suspend fun getShmotkebi(): Response<List<ShmotkaDto>>
}