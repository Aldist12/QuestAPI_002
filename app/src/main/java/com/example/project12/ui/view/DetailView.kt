package com.example.project12.ui.view

import com.example.project12.navigation.DestinasiNavigasi

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail/{nim}"
    override val titleRes = "Detail Mahasiswa"
    const val NIM = "nim"
    val routeWithArgs = "$route/{$NIM}"
}

