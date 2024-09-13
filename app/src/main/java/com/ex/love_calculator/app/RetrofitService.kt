package com.ex.love_calculator.app

import com.ex.love_calculator.interfaces.LoveApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

   private val retrofit = Retrofit.Builder().
        baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(LoveApiServices::class.java)


}