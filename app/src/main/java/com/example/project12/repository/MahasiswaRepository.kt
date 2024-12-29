package com.example.project12.repository

import com.example.project12.model.Mahasiswa
import com.example.project12.service_api.MahasiswaService
import kotlinx.serialization.InternalSerializationApi
import okio.IOException

interface MahasiswaRepository{
    @OptIn(InternalSerializationApi::class)
    suspend fun getMahasiswa(): List<Mahasiswa>
    @OptIn(InternalSerializationApi::class)
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    @OptIn(InternalSerializationApi::class)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    @OptIn(InternalSerializationApi::class)
    suspend fun getMahasiswaById(nim: String): Mahasiswa
}

class NetworkMahasiswaRepository(
    private val MahasiswaApiService: MahasiswaService
): MahasiswaRepository{
    @OptIn(InternalSerializationApi::class)
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        MahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    @OptIn(InternalSerializationApi::class)
    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        MahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = MahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful){
                throw IOException("Failed to delete mahasiswa. HTTP Status code: ${response.code()}")
            } else{
                response.message()
                println(response.message())
            }
        } catch (e:Exception){
            throw e
        }
    }

    @OptIn(InternalSerializationApi::class)
    override suspend fun getMahasiswa(): List<Mahasiswa> = MahasiswaApiService.getMahasiswa()
    @OptIn(InternalSerializationApi::class)
    override suspend fun getMahasiswaById(nim: String): Mahasiswa {
        return MahasiswaApiService.getMahasiswaById(nim)
    }

}