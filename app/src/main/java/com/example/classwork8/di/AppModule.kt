package com.example.classwork8.di

import com.example.classwork8.data.remote.apis.ShmotkebiApi
import com.example.classwork8.data.remote.repositorys.ShmotkepiRepositoryImpl
import com.example.classwork8.domain.repositorys.ShmotkepiRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().baseUrl("https://run.mocky.io/").addConverterFactory(
            MoshiConverterFactory.create(moshi)
        ).build()
    }

    @Binds
    @Singleton
    fun getApi(retrofit: Retrofit): ShmotkebiApi {
        return retrofit.create(ShmotkebiApi::class.java)
    }

    @Binds
    @Singleton
    fun getShmotkebiRepository(api: ShmotkebiApi): ShmotkepiRepository{
        return ShmotkepiRepositoryImpl(api)
    }

}