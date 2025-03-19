package com.feature.assessment.data.repo

import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.domain.model.Image
import com.assesment.domain.repo.CarRepository
import com.core.network.repository.CarsRepositoryImpl
import javax.inject.Inject

class CarsRemoteDataSource @Inject constructor(private val provider: CarsRepositoryImpl) :
    CarRepository {
    override suspend fun getCarsList(): List<CarSearchResponseItem> {
        return provider.getCars().map { it ->
            CarSearchResponseItem(
                it.id,
                it.images?.map { Image(it.url) },
                it.make,
                it.mileage,
                it.fuel,
                it.model,
                it.price,
                it.make,
                it.model,
                it.modelline,
                it.description
            )
        }
    }
}
