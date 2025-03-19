package com.core.network.di

import com.core.network.api.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBaseURL(): String {
        return "http://private-fe87c-simpleclassifieds.apiary-mock.com/"
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttp(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder();
        okHttpClient.addInterceptor(interceptor)
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        baseURL: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val retro = Retrofit.Builder().baseUrl(baseURL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build();
        return retro;
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): DataSource {
        return retrofit.create(DataSource::class.java)
    }

    @Provides
    fun provideIDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}