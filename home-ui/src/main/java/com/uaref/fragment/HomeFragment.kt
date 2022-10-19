package com.uaref.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.uaref.home_ui.databinding.FragmentHomeBinding
import com.uaref.viewModel.HomeViewModel
import org.koin.android.ext.android.inject

internal class HomeFragment : BaseFragment(), HasLifeCycleObserver {
    private val viewModel: HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.events.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.Event.OnClickEuropean -> Toast.makeText(
                    context,
                    "Open profile (ID:${it.id}, European)",
                    Toast.LENGTH_SHORT
                ).show()
                is HomeViewModel.Event.OnClickUkrainian -> Toast.makeText(
                    context,
                    "Open profile (ID:${it.id}, Ukrainian)",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun addLifecycleObserver() {
        lifecycle.addObserver(viewModel)
    }
}
