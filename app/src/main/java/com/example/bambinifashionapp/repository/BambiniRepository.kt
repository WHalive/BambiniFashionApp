package com.example.bambinifashionapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.bambinifashionapp.database.BambiniDatabase
import com.example.bambinifashionapp.database.PromotionEntity
import com.example.bambinifashionapp.internet.FashionApi
import com.example.bambinifashionapp.internet.FashionApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val DATABASE_NAME = "bambini_database"

class BambiniRepository(context: Context, private val api: FashionApi) {
//
//    companion object {
//        private var INSTANCE: BambiniRepository? = null
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                INSTANCE = BambiniRepository(context)
//            }
//        }
//
//        fun get(): BambiniRepository {
//            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
//        }
//    }

    private val database: BambiniDatabase = Room.databaseBuilder(
        context.applicationContext,
        BambiniDatabase::class.java,
        DATABASE_NAME
    ).build()

    val allPromotions: LiveData<List<PromotionEntity>> = database.promotionDao().getAllPromotions()

//    suspend fun refreshPromotions() {
//        withContext(Dispatchers.IO) {
//            try {
//                val promotion = api.retrofitService.getPromotion()
//                database.promotionDao().insertItem(promotion)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
}
