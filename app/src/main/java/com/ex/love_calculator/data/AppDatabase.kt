package com.ex.love_calculator.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ex.love_calculator.models.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao():LoveDao
}