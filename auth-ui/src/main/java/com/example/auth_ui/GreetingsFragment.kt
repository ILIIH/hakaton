package com.example.auth_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.auth_ui.databinding.FragmentGreetingsBinding


class GreetingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentGreetingsBinding.inflate(layoutInflater,container, false)
        view.getStartedButton.setOnClickListener {
            findNavController().navigate(R.id.action_greetingsFragment_to_loginFragment)
        }
        return view.root
    }


}