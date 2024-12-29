package com.example.project12.service_api

import com.example.project12.model.Mahasiswa
import kotlinx.serialization.InternalSerializationApi
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface MahasiswaService {
    @OptIn(InternalSerializationApi::class)
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("bacamahasiswa.php")
    suspend fun getMahasiswa(): List<Mahasiswa>

    @OptIn(InternalSerializationApi::class)
    @GET("bacamahasiswa.php/{nim}")
    suspend fun getMahasiswaById(@Query("nim") nim: String): Mahasiswa

    @OptIn(InternalSerializationApi::class)
    @POST("insertmahasiswa.php")
    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa)

    @OptIn(InternalSerializationApi::class)
    @PUT("editmahasiswa.php/{nim}")
    suspend fun updateMahasiswa(@Query("nim") nim: String, @Body mahasiswa: Mahasiswa)

    @DELETE("deletemahasiswa.php/{nim}")
    suspend fun deleteMahasiswa(@Query("nim") nim: String): Response<Void>
}