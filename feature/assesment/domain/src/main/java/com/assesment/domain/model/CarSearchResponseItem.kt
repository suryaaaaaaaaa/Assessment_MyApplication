package com.assesment.domain.model

data class CarSearchResponseItem(

    val id: Int,
    val images: List<Image>?,
    val make: String,
    val mileage: Int?,
    val model: String,
    val modelline: String,
    val price: Int,
    val colour: String?,
    val description: String,
    val firstRegistration: String?,
    val fuel: String,
)

data class Image(
    val url: String?
)

