package com.example.creditscore.ui.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.creditscore.R
import com.example.creditscore.data.models.CreditReport
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
        with(binding) {
            lifecycleScope.launchWhenStarted {
                homeFragmentViewModel.creditInfoResponse.collect { creditInfoResponse ->
                    renderViews(creditInfoResponse)
                    when (creditInfoResponse) {
                        is Initial -> {
                        }

                        is Loading -> {
                        }

                        is Success -> {
                            initCreditScoreView(creditInfoResponse.creditReport)
                        }

                        is Failure -> {
                            errorTextview.text = creditInfoResponse.message
                        }
                    }
                }
            }
        }
    }

    private fun initCreditScoreView(creditReport: CreditReport) {
        with(binding) {
            val creditScoreText =
                getString(R.string.tx_credit_score, creditReport.maxScoreValue)
            textMaxCreditScore.text = creditScoreText
            textUserScore.text = creditReport.score.toString()
            progressBar.progress = creditReport.creditPercent

            creditScoreView.setOnClickListener {
                val bundle = Bundle().apply {
                    putParcelable(HOME_FRAGMENT_PARCELABLE, creditReport)
                }
                navigate(
                    R.id.action_homeFragment_to_creditScoreDetailFragment,
                    args = bundle
                )
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

    companion object {
        const val HOME_FRAGMENT_PARCELABLE = "HOME_FRAGMENT_PARCELABLE"
    }
}