package com.core.network.model

import com.google.gson.annotations.SerializedName

data class CarSearchResponseItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("make")
    val make: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("colour")
    val colour: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("firstRegistration")
    val firstRegistration: String?,
    @SerializedName("fuel")
    val fuel: String,
    @SerializedName("mileage")
    val mileage: Int?,
    @SerializedName("modelline")
    val modelline: String,

)

data class Image(
    @SerializedName("url")
    val url: String?
)
