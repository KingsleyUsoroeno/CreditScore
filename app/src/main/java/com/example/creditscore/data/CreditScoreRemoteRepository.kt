package com.example.creditscore.data

import com.example.creditscore.data.remote.dto.response.CreditInfoResponse

interface CreditScoreRemoteRepository {
    suspend fun fetchCreditScore(): CreditInfoResponse
}