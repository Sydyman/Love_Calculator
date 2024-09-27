package com.ex.love_calculator.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_Table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName:String,
    val secondName:String,
    val percent:String,
    val result:String)
