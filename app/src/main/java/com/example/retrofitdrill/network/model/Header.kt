package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Header(
    @SerialName("reqNo")
    val reqNo: Int?,
    @SerialName("resultCode")
    val resultCode: String?,
    @SerialName("resultMsg")
    val resultMsg: String?
)