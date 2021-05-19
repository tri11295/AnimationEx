package com.example.animationapplication.model

data class Product(var name: String?)

fun initProductData() = mutableListOf<Product>().apply {
    add(Product("Product Name 1"))
    add(Product("Product Name 2"))
    add(Product("Product Name 3"))
    add(Product("Product Name 4"))
    add(Product("Product Name 5"))
    add(Product("Product Name 6"))
    add(Product("Product Name 7"))
    add(Product("Product Name 8"))
    add(Product("Product Name 9"))
    add(Product("Product Name 10"))
}
