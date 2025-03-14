package com.assesment.domain.repo
import com.assesment.domain.model.CarSearchResponseItem

interface RepoInterface {
    suspend fun getCarsList(): List<CarSearchResponseItem>

}