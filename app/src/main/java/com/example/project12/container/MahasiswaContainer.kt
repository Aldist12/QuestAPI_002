package com.example.project12.container

import com.example.project12.repository.MahasiswaRepository

interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}
