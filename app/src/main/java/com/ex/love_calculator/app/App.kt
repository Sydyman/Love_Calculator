package com.ex.love_calculator.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ex.love_calculator.data.AppDatabase
import com.ex.love_calculator.data.HistoryDao
import com.ex.love_calculator.data.HistoryDatabase
import com.ex.love_calculator.data.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class App: Application() {
}