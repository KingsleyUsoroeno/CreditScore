package com.example.creditscore.data.remote.dto

data class CreditReportInfoDto(
    val score: Int,
    val scoreBand: Int,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Int,
    val minScoreValue: Int,
    val percentageCreditUsed: Int,
)