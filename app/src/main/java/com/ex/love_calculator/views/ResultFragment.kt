package com.ex.love_calculator.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ex.love_calculator.R
import com.ex.love_calculator.databinding.FragmentResultBinding
import com.ex.love_calculator.interfaces.LoveApiServices
import com.ex.love_calculator.interfaces.ShowResult
import com.ex.love_calculator.models.LoveModel
import com.ex.love_calculator.presenter.MainPresenter


class ResultFragment : Fragment(),ShowResult {
    private lateinit var presenter: MainPresenter

    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenter(this)


        val firstName = arguments?.getString("first_name") ?: ""
        val secondName = arguments?.getString("second_name") ?: ""


        binding.tvFirst.text = firstName
        binding.tvSecond.text = secondName


        presenter.getPercentage(firstName, secondName)

        binding.btnAgain.setOnClickListener {
            presenter.getPercentage(firstName,secondName)
        }



    }





    override fun showResult(percent: String, result: String) {
        binding.tvResult.text = result
        binding.tvScore.text = percent
    }

}