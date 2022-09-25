package com.example.classwork8.domain.usecases


import com.example.classwork8.common.extensions.remoteToLocalList
import com.example.classwork8.domain.models.ShmotkebiModel
import com.example.classwork8.domain.repositorys.GetShmotkebiDBRepo
import javax.inject.Inject

class InsertInDbUseCase @Inject constructor(private val repoLocal: GetShmotkebiDBRepo) {
    suspend operator fun invoke(list: List<ShmotkebiModel>) {
        repoLocal.delete()
        repoLocal.insertShmotka(*(list.remoteToLocalList().toTypedArray()))
    }
}