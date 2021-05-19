package com.example.animationapplication

import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.example.animationapplication.adapters.ProductAdapter
import com.example.animationapplication.model.initProductData
import com.example.animationapplication.utils.ViewToAnotherAnimationUtil
import kotlinx.android.synthetic.main.activity_cart_view.*

class CartViewActivity : AppCompatActivity() {

    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_view)

        initView()
    }

    private fun initView() {
        productAdapter = ProductAdapter()
        recyclerProduct.adapter = productAdapter
        productAdapter.differ.submitList(initProductData())
        productAdapter.setOnItemCartClick {
            ViewToAnotherAnimationUtil.translateAnimation(viewAnimation, it, imageCartMain, object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {

                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })
        }
    }
}