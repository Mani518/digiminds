package com.digitalminds.demo.data.api

import com.digitalminds.demo.data.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun getProductsList(): Call<List<Product>>
}