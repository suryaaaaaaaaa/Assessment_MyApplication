package com.core.network.repository

import com.core.network.api.DataSource
import com.core.network.model.CarSearchResponseItem
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val apiService: DataSource,
) {
    suspend fun getCars(): List<CarSearchResponseItem> = apiService.getCars()
}