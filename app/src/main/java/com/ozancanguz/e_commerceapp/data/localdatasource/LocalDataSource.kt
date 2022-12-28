package com.ozancanguz.e_commerceapp.data.localdatasource

import androidx.lifecycle.LiveData
import com.ozancanguz.e_commerceapp.data.db.ProductDao
import com.ozancanguz.e_commerceapp.data.db.entities.FavoritesEntity
import com.ozancanguz.e_commerceapp.data.db.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val productDao: ProductDao) {


    // for all product
    fun listAllProducts(): Flow<List<ProductEntity>> {
        return productDao.ListAllProducts()
    }


    suspend fun insertProduct(productEntity: ProductEntity){
        return productDao.insertProduct(productEntity)

    }

    // -----------------------
    // for favorites product

    fun listAllFavoritesProducts():Flow<List<FavoritesEntity>> {
        return productDao.listallFavorites()
    }

    suspend fun insertFavorites(favoritesEntity: FavoritesEntity){
        return productDao.insertFavProduct(favoritesEntity)
    }

    // delete all from fav
    suspend fun deleteAll(){
        return productDao.deleteAll()
    }




}