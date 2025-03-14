package com.feature.assessment.data.repo
import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.domain.model.Image
import com.assesment.domain.repo.RepoInterface
import com.core.network.repository.CarsRepository
import javax.inject.Inject

class RepoImpl @Inject constructor(private val provider: CarsRepository) : RepoInterface {
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
