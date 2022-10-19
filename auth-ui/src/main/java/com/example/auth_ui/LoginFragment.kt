package com.example.auth_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.auth_domain.models.models.loginState
import com.example.auth_domain.models.models.userDomain
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

        viewModel._curUser.observe(requireActivity()) {
            when (it) {
                is loginState.Success -> {
                    // navigation+
                    Toast.makeText(context, "Sucess ", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(com.example.servise_review_ui.R.id.servise_review_navigation)
                }
                is loginState.Error -> {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

        view.signInButton.setOnClickListener {
            viewModel.login(
                userDomain(
                    view.editTextTextLogin.text.toString(),
                    "",
                    view.editTextPassword.text.toString()
                )
            )
        }

        view.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        return view.root
    }
}
