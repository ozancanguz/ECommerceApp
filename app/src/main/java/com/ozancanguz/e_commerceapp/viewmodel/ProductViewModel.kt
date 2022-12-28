package com.ozancanguz.e_commerceapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.e_commerceapp.data.Repository
import com.ozancanguz.e_commerceapp.data.model.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    var productList=MutableLiveData<Products>()
    var job: Job?=null

    fun requestProductData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getProducts()
            if(response.isSuccessful){
                productList.postValue(response.body())
                Log.d("productviewmodel","response" +response.body())

            }
        }
    }




}