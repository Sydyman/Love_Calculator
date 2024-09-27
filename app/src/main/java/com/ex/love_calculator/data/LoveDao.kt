package com.ex.love_calculator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ex.love_calculator.models.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(lioveModel: LoveModel)
    /* ORDER BY fname ASC*/
    @Query("SELECT * FROM `love-table` ORDER BY fname ASC")
    fun getAll(): LiveData<LoveModel>
}