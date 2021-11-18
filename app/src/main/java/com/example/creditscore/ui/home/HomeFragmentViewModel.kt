package com.example.creditscore.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditscore.data.CreditScoreRepository
import com.example.creditscore.data.models.CreditReport
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val creditScoreRepository: CreditScoreRepository
) : ViewModel() {

    private val _creditInfoResponse =
        MutableStateFlow<FetchCreditInfoResponse>(FetchCreditInfoResponse.Initial)

    val creditInfoResponse: StateFlow<FetchCreditInfoResponse> =
        _creditInfoResponse.asStateFlow()

    init {
        fetchCreditScore()
    }

    private fun fetchCreditScore() {
        _creditInfoResponse.value = FetchCreditInfoResponse.Loading
        viewModelScope.launch {
            val response = runCatching { creditScoreRepository.getCreditScore() }
            response.onSuccess { _creditInfoResponse.value = FetchCreditInfoResponse.Success(it) }
            response.onFailure {
                _creditInfoResponse.value = FetchCreditInfoResponse.Failure(
                    it.message ?: "Something went wrong, please try again later"
                )
            }
        }
    }
}

sealed class FetchCreditInfoResponse {
    object Initial : FetchCreditInfoResponse()
    object Loading : FetchCreditInfoResponse()
    data class Success(val creditReport: CreditReport) : FetchCreditInfoResponse()
    data class Failure(val message: String) : FetchCreditInfoResponse()
}