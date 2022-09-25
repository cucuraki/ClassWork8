package com.example.classwork8.domain.usecases

import com.example.classwork8.common.extensions.localToAdapterList
import com.example.classwork8.domain.repositorys.GetShmotkebiDBRepo
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShmotkebiFromDBUseCase @Inject constructor(private val repoLocal: GetShmotkebiDBRepo) {
    operator fun invoke() = flow{
        repoLocal.getShmotkebi().collect(){
            emit(it.localToAdapterList())
        }
    }

}