package com.digitalminds.demo.ui.product

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalminds.demo.R

class ProductListActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.getProducts().observe(this, { products ->
            if (products != null) {
                productAdapter.setProductList(products)
            } else {
                Toast.makeText(this, "Failed to load products", Toast.LENGTH_SHORT).show()
            }
        })
    }
}