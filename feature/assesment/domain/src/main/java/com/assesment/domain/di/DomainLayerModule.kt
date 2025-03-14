package com.assesment.domain.di

import com.assesment.domain.repo.RepoInterface
import com.assesment.domain.usecases.GetCarsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {
    @Provides
    fun getCarListUseCase(repo: RepoInterface): GetCarsListUseCase{
        return GetCarsListUseCase(repo)
    }
}