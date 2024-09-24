package com.ex.love_calculator.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ex.love_calculator.R
import com.ex.love_calculator.databinding.FragmentPagingBinding


class PagingFragment : Fragment() {

    private lateinit var binding: FragmentPagingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiliaze()
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "arg_onboard_position"

    }


    private fun initiliaze() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                tvFirst.text = "It`s Funs and many more"

            }

            1 -> {
                tvFirst.text =
                    "Have a good time You Should take the time to help those who need you"
            }

            2 -> {
                tvFirst.text =
                    "Cherishing love " + "It is now no longer possible for you to cherish love"

            }

            3 -> {

                tvFirst.text =
                    "Have a breakup? " + "We have made the correction  for you don`t worry Maybe someone is waiting for you"

            }

        }
    }


}