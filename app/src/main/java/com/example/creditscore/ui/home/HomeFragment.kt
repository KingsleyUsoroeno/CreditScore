package com.example.creditscore.ui.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.creditscore.databinding.FragmentHomeBinding
import com.example.creditscore.ui.base.BaseFragment
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
        lifecycleScope.launchWhenStarted {
            homeFragmentViewModel.creditInfoResponse.collect {
                when (it) {
                    is FetchCreditInfoResponse.Initial -> {
                    }

                    is FetchCreditInfoResponse.Loading -> {
                    }

                    is FetchCreditInfoResponse.Success -> {
                        println("fetched credit report is ${it.creditReport}")
                    }

                    is FetchCreditInfoResponse.Failure -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}