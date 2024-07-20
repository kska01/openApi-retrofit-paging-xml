package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("body")
    val body: Body?,
    @SerialName("header")
    val header: Header?
)