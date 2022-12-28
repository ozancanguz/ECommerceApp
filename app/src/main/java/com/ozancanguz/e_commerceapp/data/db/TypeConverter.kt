package com.ozancanguz.e_commerceapp.data.db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.e_commerceapp.data.model.Products

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

}