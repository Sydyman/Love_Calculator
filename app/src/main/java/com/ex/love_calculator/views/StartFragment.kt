package com.ex.love_calculator.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ex.love_calculator.R
import com.ex.love_calculator.app.RetrofitService
import com.ex.love_calculator.databinding.FragmentStartBinding
import com.ex.love_calculator.interfaces.ShowResult
import com.ex.love_calculator.presenter.MainPresenter
import retrofit2.Retrofit


class StartFragment : Fragment(),ShowResult {

    private lateinit var presenter: MainPresenter
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
        presenter = MainPresenter(this)
        setUplisteners()


    }
    private fun setUplisteners() = with(binding) {

        btnNext.setOnClickListener {
            val firstName = etFirst.text.toString()
            val secondName = etSecond.text.toString()


            val resultFragment = ResultFragment()


            val bundle = Bundle().apply {
                putString("first_name", firstName)
                putString("second_name", secondName)
            }


            resultFragment.arguments = bundle


            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, resultFragment)
                ?.commit()


            presenter.getPercentage(firstName, secondName)
        }
    }

    override fun showResult(percent: String, result: String) {
        if (isAdded) {
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }
    }


}



