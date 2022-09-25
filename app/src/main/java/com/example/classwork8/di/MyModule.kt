package com.example.classwork8.di

import com.example.classwork8.data.local.repositorys.ShmotkebiLocalRepoImpl
import com.example.classwork8.data.remote.apis.ShmotkebiApi
import com.example.classwork8.data.remote.repositorys.ShmotkepiRepositoryImpl
import com.example.classwork8.domain.repositorys.GetShmotkebiDBRepo
import com.example.classwork8.domain.repositorys.ShmotkepiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MyModule {

    @Binds
    @Singleton
    abstract fun getLocalShmotkebiRepo(shmotkebiLocalRepoImpl: ShmotkebiLocalRepoImpl): GetShmotkebiDBRepo
}