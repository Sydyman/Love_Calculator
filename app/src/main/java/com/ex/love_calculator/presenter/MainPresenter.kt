package com.ex.love_calculator.presenter

import android.util.Log
import android.widget.Toast
import com.ex.love_calculator.app.RetrofitService
import com.ex.love_calculator.app.RetrofitService.api
import com.ex.love_calculator.interfaces.ShowResult
import com.ex.love_calculator.models.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view:ShowResult) {

private val api = RetrofitService.api

    fun getPercentage(firstName: String, secondName: String) {


        api.getPercentage(
            key = "31f3b10fcdmshd451fcf9c1dff16p11c153jsn61318108bd9b",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {

                    val res = response.body()
                    res?.let { view.showResult( res.percentage,res.result) }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("API_FAILURE", "Ошибка выполнения запроса: ${t.message}")
            }

        })
    }

}