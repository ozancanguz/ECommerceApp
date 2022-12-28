package com.ozancanguz.e_commerceapp.data.db.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.e_commerceapp.data.model.ProductsItem


@Entity(tableName="favorites_table")
class FavoritesEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var products:ProductsItem


) {
}