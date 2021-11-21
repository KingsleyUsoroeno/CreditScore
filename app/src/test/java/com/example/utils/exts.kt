package com.example.utils

import com.example.creditscore.data.remote.CreditScoreApiService
import com.google.common.io.Resources
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.URL

private val okHttpClient: OkHttpClient
    get() = OkHttpClient.Builder().build()

internal fun buildTestApiService(mockWebServer: MockWebServer):
        CreditScoreApiService = Retrofit.Builder()
    .baseUrl(mockWebServer.url("/"))
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(CreditScoreApiService::class.java)

@Suppress("UnstableApiUsage")
internal fun readJson(path: String): String {
    val uri: URL = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}