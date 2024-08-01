package com.example.retrofitdrill.network

import com.example.retrofitdrill.BuildConfig
import com.example.retrofitdrill.network.model.AnimalResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface AnimalsApiService {
    @GET("1543061/abandonmentPublicSrvc/abandonmentPublic?serviceKey=${BuildConfig.API_KEY}")
    suspend fun getAnimalInfo(
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String = "30",
        @Query("_type") type: String = "json"
    ): Response<AnimalResponse>
}