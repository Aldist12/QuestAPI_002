package com.example.project12.ui.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project12.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi


class DetailViewModel(
    private val mhsRepository: MahasiswaRepository
) : ViewModel() {
    var uiState by mutableStateOf(DetailUiState())
        private set

    @OptIn(InternalSerializationApi::class)
    fun fetchDetailMahasiswa(nim: String) {
        viewModelScope.launch {
            uiState = DetailUiState(isLoading = true)
            try {
                val mahasiswa = mhsRepository.getMahasiswaById(nim)
                uiState = DetailUiState(detailUiEvent = mahasiswa.toDetailEvent())
            } catch (e: Exception) {
                e.printStackTrace()
                uiState = DetailUiState(
                    isError = true,
                    errorMessage = "Failed to fetch details: ${e.message}"
                )
            }
        }
    }
}
