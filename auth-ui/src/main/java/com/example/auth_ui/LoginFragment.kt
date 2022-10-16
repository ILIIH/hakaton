package com.example.auth_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.auth_ui.databinding.FragmentLoginBinding
import com.example.auth_ui.viewModel.authViewModel
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    val viewModel: authViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return view.root
    }
}
