package com.ex.love_calculator.data

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPref @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val SHOW = "show"
    }

    fun isOnBoardComplete(): Boolean {
       return sharedPreferences.getBoolean(SHOW, false)
    }

    fun setOnBoardComplete(b:Boolean){
        sharedPreferences.edit().putBoolean(SHOW,true).apply()
    }
}