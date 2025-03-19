package com.feature.assessment.data.di

import com.assesment.domain.repo.CarRepository
import com.core.network.repository.CarsRepositoryImpl
import com.feature.assessment.data.repo.CarsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {
    @Provides
    fun provideCarRepo(provides: CarsRepositoryImpl): CarRepository {
        return CarsRemoteDataSource(provides)
    }
}