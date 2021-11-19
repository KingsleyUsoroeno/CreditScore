package com.example.creditscore.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreditReport(
    val
    score: Int,
    val scoreBand: Int,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Int,
    val minScoreValue: Int,
    val percentageCreditUsed: Int,
    val personaType: String,
    val dashboardStatus: String,
) : Parcelable {
    val creditPercent: Int
        get() = ((score.toDouble() / maxScoreValue) * 100).toInt()
}