package com.ozancanguz.e_commerceapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ozancanguz.e_commerceapp.data.db.entities.FavoritesEntity
import com.ozancanguz.e_commerceapp.data.db.entities.ProductEntity


@Database(
    entities = [ProductEntity::class,FavoritesEntity::class],
    version = 1,
    exportSchema = false,
)

@TypeConverters(TypeConverter::class)
abstract class ProductsDatabase: RoomDatabase() {

    abstract fun productDao():ProductDao

}