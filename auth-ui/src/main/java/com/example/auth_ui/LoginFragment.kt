package com.example.auth_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.auth_ui.databinding.FragmentGreetingsBinding
import com.example.auth_ui.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentLoginBinding.inflate(layoutInflater,container, false)
        return view.root
    }


}