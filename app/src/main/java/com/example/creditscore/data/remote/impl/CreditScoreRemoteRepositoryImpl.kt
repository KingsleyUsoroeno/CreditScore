package com.example.creditscore.data.remote.impl

import com.example.creditscore.data.CreditScoreRemoteRepository
import com.example.creditscore.data.remote.CreditScoreApiService
import com.example.creditscore.data.remote.dto.response.CreditInfoResponse
import javax.inject.Inject

class CreditScoreRemoteRepositoryImpl @Inject constructor(
    private val apiService: CreditScoreApiService
) : CreditScoreRemoteRepository {

    override suspend fun fetchCreditScore(): CreditInfoResponse {
        return apiService.getCreditScore()
    }
}