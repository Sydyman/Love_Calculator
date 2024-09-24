package com.ex.love_calculator.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ex.love_calculator.R
import com.ex.love_calculator.data.SharedPref
import com.ex.love_calculator.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class onBoardFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var  sharedPref : SharedPref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUplistener()
    }



    private fun initialize() {
        binding.viewPager.adapter = OnBoardAdapter(this)
    }
    private fun setUplistener()= with(binding.viewPager) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3){
                    binding.btnStart.visibility = View.VISIBLE
                }
                else binding.btnStart.visibility = View.VISIBLE
            }
        })
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_startFragment)

        }
    }

}