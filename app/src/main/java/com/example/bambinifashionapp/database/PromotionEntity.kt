package com.example.bambinifashionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "promotion_table")
data class PromotionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "duration") val duration: Long,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = " backgroundColor") val backgroundColor: String
)