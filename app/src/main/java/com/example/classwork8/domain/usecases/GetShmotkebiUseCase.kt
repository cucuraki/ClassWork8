package com.example.classwork8.domain.usecases

import com.example.classwork8.common.extensions.toAdapterList
import com.example.classwork8.common.responsestate.ResponseState
import com.example.classwork8.domain.repositorys.GetShmotkebiDBRepo
import com.example.classwork8.domain.repositorys.ShmotkepiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShmotkebiUseCase @Inject constructor(
    private val repoRemote: ShmotkepiRepository
) {

    operator fun invoke() = flow {
        when (val response = repoRemote.getShmotkebi()) {
            is ResponseState.Success -> {
                emit(ResponseState.Success(response.model.toAdapterList()))
            }
            is ResponseState.Error -> emit(ResponseState.Error(response.message))
        }
    }
}