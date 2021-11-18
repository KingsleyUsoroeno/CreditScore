package com.example.creditscore.ui.detail

import android.view.ViewGroup
import com.example.creditscore.databinding.FragmentCreditScoreDetailBinding
import com.example.creditscore.ui.base.BaseFragment

class CreditScoreDetailFragment : BaseFragment<FragmentCreditScoreDetailBinding>() {

    override fun getLayoutBinding(container: ViewGroup?): FragmentCreditScoreDetailBinding {
        return FragmentCreditScoreDetailBinding.inflate(
            layoutInflater,
            container, false
        )
    }
}