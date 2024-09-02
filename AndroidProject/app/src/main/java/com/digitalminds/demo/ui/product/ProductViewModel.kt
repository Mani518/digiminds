package com.digitalminds.demo.ui.product


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.digitalminds.demo.data.model.Product
import com.digitalminds.demo.data.repository.ProductRepository

class ProductViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    fun getProducts(): LiveData<List<Product>> {
        return productRepository.getProducts()
    }
}