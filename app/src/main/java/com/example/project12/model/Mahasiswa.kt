package com.example.project12.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@InternalSerializationApi @Serializable
data class Mahasiswa (
    val nama: String,
    val nim: String,
    val alamat: String,
    val kelas: String,
    val angkatan: String,

    @SerialName("jenis_kelamin")
    val jenisKelamin: String
)

