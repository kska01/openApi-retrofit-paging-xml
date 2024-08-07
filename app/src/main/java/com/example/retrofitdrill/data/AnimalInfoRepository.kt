package com.example.retrofitdrill.data

import com.example.retrofitdrill.network.AnimalsApiService
import com.example.retrofitdrill.network.model.AnimalResponse
import retrofit2.Response

interface AnimalInfoRepository {
    suspend fun getAnimalInfo(page: String): Response<AnimalResponse>
}

class NetworkAnimalInfoRepository(
    private val animalsApiService: AnimalsApiService
) : AnimalInfoRepository {
    override suspend fun getAnimalInfo(page: String): Response<AnimalResponse> {
        return animalsApiService.getAnimalInfo(pageNo = page)
    }
}