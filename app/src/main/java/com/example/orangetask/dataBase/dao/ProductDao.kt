package com.example.orangetask.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.orangetask.data.Product
import kotlinx.coroutines.flow.Flow
@Dao
interface ProductDao{

    @Insert
    suspend fun addProduct(product: Product)

    @Query("SELECT * FROM Product")
    fun searchProducts(): Flow<List<Product>>
}
