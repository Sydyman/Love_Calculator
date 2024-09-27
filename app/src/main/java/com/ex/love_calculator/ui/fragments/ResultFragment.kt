package com.ex.love_calculator.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ex.love_calculator.R
import com.ex.love_calculator.databinding.FragmentResultBinding
import com.ex.love_calculator.interfaces.ShowResult


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("first_name")
        val secondName = arguments?.getString("second_name")
        val percentage = arguments?.getString("percentage")

        tvFirst.text = firstName
        tvSecond.text = secondName
        tvScore.text = percentage

        binding.tvHistory.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_historyFragment)
        }
    }
}

