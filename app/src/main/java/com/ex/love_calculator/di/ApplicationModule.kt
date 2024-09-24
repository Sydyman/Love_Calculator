package com.ex.love_calculator.di

import android.content.Context
import android.content.SharedPreferences
import com.ex.love_calculator.data.SharedPref
import com.ex.love_calculator.interfaces.LoveApiServices
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    fun provideLoveApiService(): LoveApiServices {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoveApiServices::class.java)
    }

    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences? {
        return context.getSharedPreferences("my_pref", Context.MODE_PRIVATE)
    }

    fun provideShredPreferenceHelper(sharedPreferences: SharedPreferences): SharedPref {
        return SharedPref(sharedPreferences)
    }
}