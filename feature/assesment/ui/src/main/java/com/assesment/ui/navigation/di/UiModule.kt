package com.assesment.ui.navigation.di

import com.assesment.ui.navigation.CarsApi
import com.assesment.ui.navigation.CarsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideCarApi():CarsApi{
        return CarsApiImpl()

    }
}