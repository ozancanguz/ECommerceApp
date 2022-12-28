package com.ozancanguz.e_commerceapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozancanguz.e_commerceapp.data.db.entities.ProductEntity
import com.ozancanguz.e_commerceapp.data.model.Products
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {


    @Query("select * from product_table order by id asc")
    fun ListAllProducts(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity:ProductEntity)




}