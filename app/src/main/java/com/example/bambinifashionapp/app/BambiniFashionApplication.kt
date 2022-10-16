package com.example.bambinifashionapp.app

import android.app.Application
import android.os.Build.VERSION_CODES.P
import com.example.bambinifashionapp.database.BambiniDatabase
import com.example.bambinifashionapp.database.PromotionDao
import com.example.bambinifashionapp.repository.BambiniRepository

class BambiniFashionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        BambiniRepository.initialize(this)
    }

}