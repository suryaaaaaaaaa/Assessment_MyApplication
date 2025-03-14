package com.core.network.repository

import com.core.network.api.ApiService
import com.core.network.model.CarSearchResponseItem
import javax.inject.Inject

class CarsRepository @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getCars(): List<CarSearchResponseItem> = apiService.getCars()
}