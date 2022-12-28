package com.ozancanguz.e_commerceapp.data.model


import com.google.gson.annotations.SerializedName

data class ProductsItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String
)