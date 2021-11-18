package com.example.creditscore.data.remote.impl

import com.example.creditscore.data.CreditScoreRemoteRepository
import com.example.creditscore.data.remote.ApiService
import com.example.creditscore.data.remote.dto.CreditReportInfoDto
import javax.inject.Inject

class CreditScoreRemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CreditScoreRemoteRepository {

    override suspend fun fetchCreditScore(): CreditReportInfoDto {
        return apiService.getCreditScore().creditReportInfo
    }
}