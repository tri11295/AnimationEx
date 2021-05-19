package com.example.animationapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animationapplication.R
import com.example.animationapplication.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemCartClick: ((View) -> Unit)? = null

    fun setOnItemCartClick(listener: (View) -> Unit) {
        onItemCartClick = listener
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(product: Product) {
            itemView.apply {
                textProductName.text = product.name
                imageCart.setOnClickListener {
                    onItemCartClick?.invoke(it)
                }
            }

        }
    }
}