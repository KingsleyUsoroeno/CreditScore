package com.example.creditscore.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<V> : Fragment() where V : ViewBinding {

    private var _binding: V? = null
    val binding get() = _binding!!


    abstract fun getLayoutBinding(container: ViewGroup?): V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getLayoutBinding(container)

        return _binding?.root
    }

    protected fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    protected fun navigate(@IdRes resId: Int, args: Bundle = Bundle()) {
        findNavController().navigate(resId, args)
    }

    protected fun navigateUp() {
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}