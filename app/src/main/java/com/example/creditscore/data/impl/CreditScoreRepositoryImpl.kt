package com.example.creditscore.data.impl

import com.example.creditscore.data.CreditScoreRemoteRepository
import com.example.creditscore.data.CreditScoreRepository
import com.example.creditscore.data.models.CreditReport
import javax.inject.Inject

class CreditScoreRepositoryImpl @Inject constructor(
    private val creditScoreRemoteRepository: CreditScoreRemoteRepository
) : CreditScoreRepository {

    override suspend fun getCreditScore(): CreditReport {
        val creditReport = creditScoreRemoteRepository.fetchCreditScore()
        return creditReport.toCreditReport()
    }
}