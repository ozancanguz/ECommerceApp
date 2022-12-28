package com.ozancanguz.e_commerceapp.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.e_commerceapp.data.db.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ProductsDatabase::class.java,
        "product_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ProductsDatabase) = database.productDao()

}
