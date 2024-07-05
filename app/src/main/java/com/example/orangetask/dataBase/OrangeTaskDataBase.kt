package com.example.orangetask.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.orangetask.data.Product
import com.example.orangetask.dataBase.dao.ProductDao

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = true)

abstract class OrangeTaskDataBase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}