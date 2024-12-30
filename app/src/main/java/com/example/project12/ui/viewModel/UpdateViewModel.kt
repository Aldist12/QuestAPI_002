package com.example.project12.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project12.repository.MahasiswaRepository
import com.example.project12.ui.view.DestinasiUpdate
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi


@OptIn(InternalSerializationApi::class)
class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val mahasiswaRepository: MahasiswaRepository
): ViewModel(){
    var updateUiState by mutableStateOf(InsertUiState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            updateUiState = mahasiswaRepository.getMahasiswaById(_nim)
                .toUiStateMhs()
        }
    }

    fun updateInsertMhsState(insertUiEvent: InsertUiEvent){
        updateUiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    @OptIn(InternalSerializationApi::class)
    suspend fun updateMhs(){
        viewModelScope.launch {
            try {
                mahasiswaRepository.updateMahasiswa(_nim, updateUiState.insertUiEvent.toMhs())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}