package com.core.network.repository

import com.core.network.api.DataSource
import com.core.network.model.CarSearchResponseItem
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val dataSource: DataSource,
) {
    suspend fun getCars(): List<CarSearchResponseItem> = dataSource.getCars()
}