package com.example.project12

import android.app.Application
import com.example.project12.container.AppContainer
import com.example.project12.container.MahasiswaContainer

class MahasiswaApp : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}