package com.assesment.domain.repo

import com.assesment.domain.model.CarSearchResponseItem

interface CarRepository {
    suspend fun getCarsList(): List<CarSearchResponseItem>

}