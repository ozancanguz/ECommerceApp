package com.ozancanguz.e_commerceapp.data

import com.ozancanguz.e_commerceapp.data.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): Response<Products>

}