package com.example.creditscore.data.remote.dto.response

import com.example.creditscore.data.models.CreditReport
import com.example.creditscore.data.remote.dto.CreditReportInfoDto

data class CreditInfoResponse(
    val creditReportInfo: CreditReportInfoDto,
    val dashboardStatus: String,
    val personaType: String,
) {
    fun toCreditReport(): CreditReport {
        return CreditReport(
            score = creditReportInfo.score,
            scoreBand = creditReportInfo.scoreBand,
            clientRef = creditReportInfo.clientRef,
            status = creditReportInfo.status,
            maxScoreValue = creditReportInfo.maxScoreValue,
            minScoreValue = creditReportInfo.minScoreValue,
            percentageCreditUsed = creditReportInfo.percentageCreditUsed,
            personaType = personaType,
            dashboardStatus = dashboardStatus
        )
    }
}