package com.example.creditscore.data

import com.example.creditscore.data.models.CreditReport

interface CreditScoreRepository {
    suspend fun getCreditScore(): CreditReport = throw Exception()
}