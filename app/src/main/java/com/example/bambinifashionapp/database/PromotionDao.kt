package com.example.bambinifashionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PromotionDao {
    @Query("SELECT * FROM promotion_table")
    fun getAllPromotions(): LiveData<List<PromotionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: PromotionEntity)
}