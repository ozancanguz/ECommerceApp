package com.ozancanguz.e_commerceapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.e_commerceapp.data.model.Products


@Entity(tableName="product_table")
class ProductEntity(
    var product: Products

) {

    @PrimaryKey(autoGenerate = true)
    var id:Int=0


}