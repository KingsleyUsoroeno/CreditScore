package com.example.creditscore.ui.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.creditscore.R
import com.example.creditscore.databinding.FragmentHomeBinding
import com.example.creditscore.ui.base.BaseFragment
import com.example.creditscore.ui.home.FetchCreditInfoResponse.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()

    override fun getLayoutBinding(container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCreditScore()
    }

    private fun observeCreditScore() {
        with(binding) {
            lifecycleScope.launchWhenStarted {
                homeFragmentViewModel.creditInfoResponse.collect {
                    renderViews(it)
                    when (it) {
                        is Initial -> {
                        }

                        is Loading -> {
                        }

                        is Success -> {
                            val creditScoreText =
                                getString(R.string.tx_credit_score, it.creditReport.maxScoreValue)
                            textMaxCreditScore.text = creditScoreText
                            textUserScore.text = it.creditReport.score.toString()
                            progressBar.progress = it.creditReport.creditPercent

                            creditScoreView.setOnClickListener { }
                        }

                        is Failure -> {
                            errorTextview.text = it.message
                        }
                    }
                }
            }
        }
    }

    private fun renderViews(viewState: FetchCreditInfoResponse) {
        with(binding) {
            errorView.visibility = if (viewState is Failure) View.VISIBLE else View.GONE
            loadingView.visibility = if (viewState is Loading) View.VISIBLE else View.GONE
            creditScoreView.visibility = if (viewState is Success) View.VISIBLE else View.GONE
        }
    }
}