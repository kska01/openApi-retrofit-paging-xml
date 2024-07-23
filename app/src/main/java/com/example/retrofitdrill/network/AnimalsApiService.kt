package com.example.retrofitdrill.network

import com.example.retrofitdrill.BuildConfig
import com.example.retrofitdrill.network.model.AnimalResponse
import com.example.retrofitdrill.network.model.Item
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://apis.data.go.kr/"

interface AnimalsApiService {
    @GET("1543061/abandonmentPublicSrvc/abandonmentPublic?serviceKey=${BuildConfig.API_KEY}")
    suspend fun getAnimalInfo(
        @Query("pageNo") pageNo: String,
        @Query("endde") endde: String = "20240723",
        @Query("numOfRows") numOfRows: String = "30",
        @Query("_type") type: String = "json"
    ): Response<AnimalResponse>
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

object AnimalApi {
    val retrofitService : AnimalsApiService by lazy {
        retrofit.create(AnimalsApiService::class.java)
    }
}