package com.uaref.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.servise_review_ui.R
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
                is HomeViewModel.Event.OnClickEuropean -> {
                    val bundle = Bundle()
                    bundle.putString("type", "European")
                    bundle.putInt("id", it.id)
                    findNavController().navigate(R.id.servise_review_navigation, bundle)
                }
                is HomeViewModel.Event.OnClickUkrainian -> {
                    val bundle = Bundle()
                    bundle.putString("type", "Ukrainian")
                    bundle.putInt("id", it.id)
                    findNavController().navigate(R.id.servise_review_navigation, bundle)
                }
            }
        }
    }

    override fun addLifecycleObserver() {
        lifecycle.addObserver(viewModel)
    }
}
