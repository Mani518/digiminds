package com.digitalminds.demo.ui.product


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalminds.demo.R
import com.digitalminds.demo.data.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList: List<Product> = listOf()

    fun setProductList(products: List<Product>) {
        this.productList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.titleTextView.text = product.title
        holder.descriptionTextView.text = product.description
        holder.priceTextView.text = "$${product.price}"

        // Use Glide to load the product image
        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.productImageView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.product_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.product_description)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        val productImageView: ImageView = itemView.findViewById(R.id.product_image)
    }
}