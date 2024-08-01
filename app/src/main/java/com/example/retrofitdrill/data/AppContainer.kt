package com.example.retrofitdrill.data

import com.example.retrofitdrill.network.AnimalsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val animalInfoRepository: AnimalInfoRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://apis.data.go.kr/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService : AnimalsApiService by lazy {
        retrofit.create(AnimalsApiService::class.java)
    }

    override val animalInfoRepository: AnimalInfoRepository by lazy {
        NetworkAnimalInfoRepository(retrofitService)
    }
}