package com.example.orangetask.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String = "",
    val isCheck: Boolean = false,
    @ColumnInfo(defaultValue = "")
    val image: String = "",
)
