package com.ex.love_calculator.interfaces

import com.ex.love_calculator.models.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiServices {
    @GET("getPercentage")

    fun getPercentage(
        @Header("X-Rapidapi-Key")key:String,
        @Header("X-Rapidapi-Host")host:String,
        @Query("fname")firstName:String,
        @Query("sname")secondName:String
    ): Call<LoveModel>

}