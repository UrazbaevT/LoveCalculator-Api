package com.example.lovecalculator_api

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator_api.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love_table")
                .allowMainThreadQueries().build()
    }

}