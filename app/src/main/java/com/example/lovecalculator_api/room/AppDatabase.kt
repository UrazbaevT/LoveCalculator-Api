package com.example.lovecalculator_api.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator_api.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loveDao(): LoveDao
}