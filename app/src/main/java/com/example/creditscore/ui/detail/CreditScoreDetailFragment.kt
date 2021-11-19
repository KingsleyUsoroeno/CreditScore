package com.example.creditscore.ui.detail

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.creditscore.data.models.CreditReport
import com.example.creditscore.databinding.FragmentCreditScoreDetailBinding
import com.example.creditscore.ui.base.BaseFragment
import com.example.creditscore.ui.home.HomeFragment

class CreditScoreDetailFragment : BaseFragment<FragmentCreditScoreDetailBinding>() {

    override fun getLayoutBinding(container: ViewGroup?): FragmentCreditScoreDetailBinding {
        return FragmentCreditScoreDetailBinding.inflate(
            layoutInflater,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val creditReport =
                bundle.getParcelable<CreditReport>(HomeFragment.HOME_FRAGMENT_PARCELABLE)
            with(binding) {
                txUserScore.text = creditReport?.score.toString()
                textMaxCreditScore.text = creditReport?.maxScoreValue.toString()
                txUserAccountStatus.text = creditReport?.dashboardStatus
                txPersonalTypeInfo.text = creditReport?.personaType
                txUserMinScore.text = creditReport?.minScoreValue.toString()
            }
        }
    }
}