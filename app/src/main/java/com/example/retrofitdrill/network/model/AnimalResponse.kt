package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimalResponse(
    @SerialName("response")
    val response: Response?
)