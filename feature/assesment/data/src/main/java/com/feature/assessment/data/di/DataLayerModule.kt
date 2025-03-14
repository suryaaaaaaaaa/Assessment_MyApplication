package com.feature.assessment.data.di

import com.assesment.domain.repo.RepoInterface
import com.core.network.repository.CarsRepository
import com.feature.assessment.data.repo.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {
    @Provides
    fun provideCarRepo(provides: CarsRepository): RepoInterface{
        return RepoImpl(provides)
    }
}