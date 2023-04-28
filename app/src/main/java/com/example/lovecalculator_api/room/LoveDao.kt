package com.example.lovecalculator_api.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator_api.remote.LoveModel

@Dao
interface LoveDao{

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_model")
    fun getAll():List<LoveModel>

    @Query("SELECT * FROM love_model ORDER BY firstName ASC")
    fun getAllSort():List<LoveModel>

}