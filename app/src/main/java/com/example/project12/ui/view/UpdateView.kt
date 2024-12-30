package com.example.project12.ui.view

import com.example.project12.navigation.DestinasiNavigasi

object DestinasiUpdate: DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Mahasiswa"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
}
