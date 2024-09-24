package com.ex.love_calculator.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ex.love_calculator.R
import com.ex.love_calculator.data.SharedPref
import com.ex.love_calculator.databinding.ActivityMainBinding
import com.ex.love_calculator.interfaces.LoveApiServices
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @Inject
    lateinit var sharedPref: SharedPref

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var api: LoveApiServices


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        if (!sharedPref.isOnBoardComplete()) {
            sharedPref.setOnBoardComplete(true)

        } else
            navController.navigate(R.id.action_onBoardFragment_to_startFragment)


    }
}