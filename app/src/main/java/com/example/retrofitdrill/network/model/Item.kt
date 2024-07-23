package com.example.retrofitdrill.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("age")
    val age: String,
    @SerialName("careAddr")
    val careAddr: String,
    @SerialName("careNm")
    val careNm: String,
    @SerialName("careTel")
    val careTel: String,
    @SerialName("chargeNm")
    val chargeNm: String,
    @SerialName("colorCd")
    val colorCd: String,
    @SerialName("desertionNo")
    val desertionNo: String,
    @SerialName("filename")
    val filename: String,
    @SerialName("happenDt")
    val happenDt: String,
    @SerialName("happenPlace")
    val happenPlace: String,
    @SerialName("kindCd")
    val kindCd: String,
    @SerialName("neuterYn")
    val neuterYn: String,
    @SerialName("noticeEdt")
    val noticeEdt: String,
    @SerialName("noticeNo")
    val noticeNo: String,
    @SerialName("noticeSdt")
    val noticeSdt: String,
    @SerialName("officetel")
    val officetel: String,
    @SerialName("orgNm")
    val orgNm: String,
    @SerialName("popfile")
    val popfile: String,
    @SerialName("processState")
    val processState: String,
    @SerialName("sexCd")
    val sexCd: String,
    @SerialName("specialMark")
    val specialMark: String,
    @SerialName("weight")
    val weight: String
)