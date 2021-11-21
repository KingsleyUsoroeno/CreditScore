package com.example.creditscore.di

import com.example.creditscore.BuildConfig
import com.example.creditscore.data.CreditScoreRemoteRepository
import com.example.creditscore.data.CreditScoreRepository
import com.example.creditscore.data.impl.CreditScoreRepositoryImpl
import com.example.creditscore.data.remote.ApiServiceFactory
import com.example.creditscore.data.remote.CreditScoreApiService
import com.example.creditscore.data.remote.impl.CreditScoreRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @get:[Binds Singleton]
    val CreditScoreRepositoryImpl.bindCreditScoreRepository: CreditScoreRepository

    @get:[Binds Singleton]
    val CreditScoreRemoteRepositoryImpl.bindCreditScoreRemoteRepository: CreditScoreRemoteRepository

    companion object {
        @[Provides Singleton]
        fun provideApiService(): CreditScoreApiService {
            return ApiServiceFactory.buildCreditScoreApiService(BuildConfig.DEBUG)
        }
    }
}