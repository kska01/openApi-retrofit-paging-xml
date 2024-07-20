package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Body(
    @SerialName("items")
    val items: Items?,
    @SerialName("numOfRows")
    val numOfRows: Int?,
    @SerialName("pageNo")
    val pageNo: Int?,
    @SerialName("totalCount")
    val totalCount: Int?
)