package com.ozancanguz.e_commerceapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.e_commerceapp.data.model.Products
import com.ozancanguz.e_commerceapp.data.model.ProductsItem

class TypeConverter {

    var gson = Gson()

    @androidx.room.TypeConverter
    fun ProductToString(product: Products): String {
        return gson.toJson(product)
    }

    @androidx.room.TypeConverter
    fun stringToProducts(data: String): Products {
        val listType = object : TypeToken<Products>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun ProductsItemToString(productsItem: ProductsItem):String{
        return gson.toJson(productsItem)
    }

    @TypeConverter
    fun stringToProductsItem(data:String):ProductsItem{
        val listType=object : TypeToken <ProductsItem>(){
        }.type
        return gson.fromJson(data,listType)
    }


}