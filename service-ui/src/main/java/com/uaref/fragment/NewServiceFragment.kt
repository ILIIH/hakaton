package com.uaref.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.service_ui.databinding.FragmentNewServiceBinding
import com.uaref.viewModel.NewServiceViewModel
import org.koin.android.ext.android.inject

internal class NewServiceFragment : BaseFragment(), HasLifeCycleObserver {
    private var binding: FragmentNewServiceBinding? = null

    private val viewModel: NewServiceViewModel by inject()

    override fun addLifecycleObserver() {
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewServiceBinding.inflate(inflater, container, false).apply {
            viewModel = this@NewServiceFragment.viewModel
            lifecycleOwner = this@NewServiceFragment
        }
        return binding?.root
    }
}
