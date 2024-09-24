package com.ex.love_calculator.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ex.love_calculator.interfaces.LoveApiServices
import com.ex.love_calculator.models.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculationViewModel @Inject constructor(
    private val api: LoveApiServices
) : ViewModel() {
    val loveResultData = MutableLiveData<LoveModel>()
    val errorData = MutableLiveData<String>()
    fun getPercentage(firstName: String, secondName: String) {
        api.getPercentage(
            firstName = firstName,
            secondName = secondName, key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(
                call: retrofit2.Call<LoveModel>, response: retrofit2.Response<LoveModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val loveResult = response.body()!!
                    loveResultData.postValue(loveResult)
                } else {
                    errorData.postValue("Could not get a correct answer")
                }
            }

            override fun onFailure(call: retrofit2.Call<LoveModel>, t: Throwable) {
                errorData.postValue("Connection error")
            }
        })
    }
}