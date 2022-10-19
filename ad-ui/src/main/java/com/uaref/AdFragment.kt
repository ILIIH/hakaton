package com.uaref

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ad_ui.databinding.FragmentAdBinding
import com.uaref.fragment.BaseFragment

internal class AdFragment : BaseFragment() {
    private var binding: FragmentAdBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdBinding.inflate(inflater, container, false)
        return binding?.root
    }
}
