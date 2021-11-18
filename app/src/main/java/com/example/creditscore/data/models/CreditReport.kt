package com.example.creditscore.data.models

data class CreditReport(
    val score: Int,
    val scoreBand: Int,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Int,
    val minScoreValue: Int,
    val percentageCreditUsed: Int,
)
