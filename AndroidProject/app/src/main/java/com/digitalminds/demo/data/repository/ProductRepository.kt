package com.digitalminds.demo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.digitalminds.demo.data.api.ApiService
import com.digitalminds.demo.data.api.RetrofitClient
import com.digitalminds.demo.data.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val apiService: ApiService = RetrofitClient.getClient().create(ApiService::class.java)

    fun getProducts(): LiveData<List<Product>> {
        val data = MutableLiveData<List<Product>>()

        apiService.getProductsList().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }
}