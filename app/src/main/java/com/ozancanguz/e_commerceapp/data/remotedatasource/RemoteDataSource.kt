package com.ozancanguz.e_commerceapp.data.remotedatasource

import com.ozancanguz.e_commerceapp.data.api.ProductsApi
import com.ozancanguz.e_commerceapp.data.model.Products
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val productsApi: ProductsApi) {


    suspend fun getProducts(): Response<Products> {
        return productsApi.getProducts()
    }



}