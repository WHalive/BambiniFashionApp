package com.example.bambinifashionapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PromotionEntity::class],
    version = 1
)
abstract class BambiniDatabase : RoomDatabase() {
    abstract fun promotionDao(): PromotionDao
}
