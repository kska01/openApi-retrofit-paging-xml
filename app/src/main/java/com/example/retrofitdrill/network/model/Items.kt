package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Items(
    @SerialName("item")
    val item: List<Item>?
)