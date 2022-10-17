package com.example.auth_ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.auth_domain.models.models.loginState
import com.example.auth_domain.models.models.userDomain
import com.example.auth_ui.databinding.FragmentSignUpBinding
import com.example.auth_ui.viewModel.authViewModel
import org.koin.android.ext.android.inject

class SignUpFragment : Fragment() {

    val viewModel: authViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        viewModel._curUser.observe(requireActivity()) {
            when (it) {
                is loginState.Success -> {
                    // navigation
                    Toast.makeText(context, "Sucess ", Toast.LENGTH_SHORT).show()
                }
                is loginState.Error -> {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

        view.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        view.signUpButton.setOnClickListener {
            Log.i("Registrate", "klick execute")
            viewModel.registrate(
                userDomain(
                    view.username.text.toString(),
                    view.emailAddress.text.toString(),
                    view.editTextPassword.text.toString()
                )
            )
        }
        return view.root
    }
}
