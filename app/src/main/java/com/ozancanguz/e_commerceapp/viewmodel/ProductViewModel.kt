package com.ozancanguz.e_commerceapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.e_commerceapp.data.Repository
import com.ozancanguz.e_commerceapp.data.db.entities.ProductEntity
import com.ozancanguz.e_commerceapp.data.model.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    // for retrofit part
    var productList=MutableLiveData<Products>()
    var job: Job?=null

    // for room part
    var listproductList:LiveData<List<ProductEntity>> = repository.local.listAllProducts().asLiveData()

    // for room insert product call
    fun insertProduct(productEntity: ProductEntity){
        viewModelScope.launch {
            repository.local.insertProduct(productEntity)
        }
    }

    // save to db
    fun saveProductsToDb(products:Products){
        var productEntity=ProductEntity(products)
        insertProduct(productEntity)
    }



     fun REQUESTPRODUCTSDATA(){
         requestProductData()
     }

    // for retrofit call
    fun requestProductData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getProducts()
            if(response.isSuccessful){
                productList.postValue(response.body())
                Log.d("productviewmodel","response" +response.body())

                val products=productList.value!!
                saveProductsToDb(products)

            }
        }
    }




}