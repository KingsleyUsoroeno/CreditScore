package com.example.repository

import com.example.creditscore.data.CreditScoreRemoteRepository
import com.example.creditscore.data.models.CreditReport
import com.example.creditscore.data.remote.dto.response.CreditInfoResponse
import com.example.creditscore.data.remote.impl.CreditScoreRemoteRepositoryImpl
import com.example.utils.RequestDispatcher
import com.example.utils.buildTestApiService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class CreditScoreRepositoryImplTest {

    private lateinit var creditScoreRemoteRepository: CreditScoreRemoteRepository
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        creditScoreRemoteRepository = CreditScoreRemoteRepositoryImpl(
            apiService = buildTestApiService(mockWebServer)
        )
    }

    @Test
    fun `check that fetchCreditScore returns data`() = runBlocking {
        val creditInfoResponse: CreditInfoResponse = creditScoreRemoteRepository.fetchCreditScore()
        val creditReport: CreditReport = creditInfoResponse.toCreditReport()
        assertThat(creditInfoResponse.dashboardStatus).isNotEmpty()
        assertThat(creditInfoResponse.personaType).isEqualTo(creditReport.personaType)
        assertThat(creditInfoResponse.creditReportInfo.score).isEqualTo(creditReport.score)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}