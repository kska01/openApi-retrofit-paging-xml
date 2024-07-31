package com.example.retrofitdrill.data

import com.example.retrofitdrill.network.AnimalApi
import com.example.retrofitdrill.network.model.AnimalResponse
import retrofit2.Response

interface AnimalInfoRepository {
    suspend fun getAnimalInfo(page: String): Response<AnimalResponse>
}

class NetworkAnimalInfoRepository() : AnimalInfoRepository {
    override suspend fun getAnimalInfo(page: String): Response<AnimalResponse> {
        return AnimalApi.retrofitService.getAnimalInfo(pageNo = page)
    }
}