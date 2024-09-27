package com.ex.love_calculator.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_table ORDER BY firstName ASC")
    fun getAllHistory(): List<HistoryEntity>

    @Insert
    fun insertHistory(historyEntity: HistoryEntity)

    @Delete
    fun delete(historyEntity: HistoryEntity)

}