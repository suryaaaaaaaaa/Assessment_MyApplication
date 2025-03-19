package com.core.network.api

import com.core.network.model.CarSearchResponseItem
import retrofit2.http.*

interface DataSource {
    @GET("/")
    suspend fun getCars(): List<CarSearchResponseItem>
}
