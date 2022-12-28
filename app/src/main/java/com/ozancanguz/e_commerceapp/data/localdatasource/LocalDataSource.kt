package com.ozancanguz.e_commerceapp.data.localdatasource

import com.ozancanguz.e_commerceapp.data.db.ProductDao
import com.ozancanguz.e_commerceapp.data.db.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val productDao: ProductDao) {


    fun listAllProducts(): Flow<List<ProductEntity>> {
        return productDao.ListAllProducts()
    }


    suspend fun insertProduct(productEntity: ProductEntity){
        return productDao.insertProduct(productEntity)

    }


}