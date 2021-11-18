package com.example.creditscore.data.remote.dto

import com.example.creditscore.data.models.CreditReport

data class CreditReportInfoDto(
    val score: Int,
    val scoreBand: Int,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Int,
    val minScoreValue: Int,
    val percentageCreditUsed: Int,
) {
    fun toCreditReport(): CreditReport {
        return CreditReport(
            score,
            scoreBand,
            clientRef,
            status,
            maxScoreValue,
            minScoreValue,
            percentageCreditUsed
        )
    }
}