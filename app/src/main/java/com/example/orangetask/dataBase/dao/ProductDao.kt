package com.example.orangetask.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.orangetask.data.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert
    suspend fun addProduct(product: Product)

    @Query("SELECT * FROM Product")
    fun searchProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE id = :id")
    fun searchProductForId(id: Long): Flow<Product>

    @Update()
    suspend fun updateProduct(product: Product)

    @Query("Delete FROM Product WHERE id = :id ")
    suspend fun removeProduct(id: Long)
}
