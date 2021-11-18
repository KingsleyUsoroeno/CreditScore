package com.example.creditscore.data

import com.example.creditscore.data.remote.dto.CreditReportInfoDto

interface CreditScoreRemoteRepository {
    suspend fun fetchCreditScore(): CreditReportInfoDto
}