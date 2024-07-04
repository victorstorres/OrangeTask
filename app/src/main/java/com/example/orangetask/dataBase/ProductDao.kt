package com.example.orangetask.dataBase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.orangetask.data.Product
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ProductDao @Inject constructor() {
    private val _listProduct: MutableList<Product> = mutableListOf(Product("Cebola"))

    val listProduct
        get() = _listProduct


    fun createProduct(product: String) {
        _listProduct.add(Product(product))
    }


     fun searchProduct(): Flow<List<Product>> {
         return listOf(listProduct).asFlow()
     }
}