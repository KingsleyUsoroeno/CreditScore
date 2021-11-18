package com.example.creditscore.data.remote

import com.example.creditscore.data.remote.dto.response.CreditInfoResponse
import retrofit2.http.GET

interface ApiService {

    @GET("endpoint.json")
    suspend fun getCreditScore(): CreditInfoResponse
}