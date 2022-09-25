package com.example.classwork8.ui.shmotkebi

import androidx.lifecycle.ViewModel
import com.example.classwork8.common.responsestate.ResponseState
import com.example.classwork8.domain.models.ShmotkebiModel
import com.example.classwork8.domain.repositorys.ShmotkepiRepository
import com.example.classwork8.domain.usecases.GetShmotkebiFromDBUseCase
import com.example.classwork8.domain.usecases.GetShmotkebiUseCase
import com.example.classwork8.domain.usecases.InsertInDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

data class State<T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = false
)

@HiltViewModel
class ShmotkebiViewModel @Inject constructor(
    private val shmotkebiUseCase: GetShmotkebiUseCase,
    private val insertUseCase: InsertInDbUseCase,
    private val localUseCase: GetShmotkebiFromDBUseCase
) : ViewModel() {
    private var _flow = MutableStateFlow<State<List<ShmotkebiModel>>>(State())
    val flow = _flow.asStateFlow()

    suspend fun getShmotkebi() {
        resetState()
        _flow.value = _flow.value.copy(loading = true)
        shmotkebiUseCase().collect {
            when (it) {
                is ResponseState.Success -> {
                    _flow.value = _flow.value.copy(data = it.model)
                    insertUseCase(it.model)
                }
                is ResponseState.Error -> {
                    localUseCase().collect{ model->
                        if(model.isEmpty()){
                            _flow.value = _flow.value.copy(error = it.message)
                        }else{
                            _flow.value = _flow.value.copy(data = model)
                        }
                    }
                }
            }
        }
    }


    private fun resetState() {
        _flow.value = _flow.value.copy(null, null, false)
    }
}