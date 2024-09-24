package com.ex.love_calculator.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ex.love_calculator.R
import com.ex.love_calculator.databinding.FragmentStartBinding
import com.ex.love_calculator.interfaces.ShowResult
import com.ex.love_calculator.models.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalculateFragment : Fragment(), ShowResult {

    private val viewModel: CalculationViewModel by viewModels()
    private lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObsevers()
        setupListeners()


    }

    private fun setupObsevers() {
        viewModel.loveResultData.observe(viewLifecycleOwner) { result ->
            navigateToResult(result)
        }
        viewModel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setupListeners() = with(binding) {

        btnNext.setOnClickListener {
            val firstName = etFirst.text.toString()
            val secondName = etSecond.text.toString()

            viewModel.getPercentage(firstName, secondName)
        }
    }

    private fun navigateToResult(loveModel: LoveModel) {
        val bundle = Bundle().apply {
            putString("percentage", loveModel.percentage)
            putString("result", loveModel.result)
        }

        findNavController().navigate(R.id.action_startFragment_to_resultFragment, bundle)
    }

    override fun showResult(fname: String, sname: String, percent: String, result: String) {
        if (isAdded) {
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }
    }
}



