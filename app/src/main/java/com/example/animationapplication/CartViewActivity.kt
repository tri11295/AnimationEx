package com.example.animationapplication

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
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

        btnDownToUp.setOnClickListener {
            recyclerProduct.layoutAnimation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_down_to_up)
            productAdapter.notifyDataSetChanged()
        }

        btnUpToDown.setOnClickListener {
            recyclerProduct.layoutAnimation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_up_to_down)
            productAdapter.notifyDataSetChanged()
        }

        btnLeftToright.setOnClickListener {
            recyclerProduct.layoutAnimation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_left_to_right)
            productAdapter.notifyDataSetChanged()
        }

        btnRightToLeft.setOnClickListener {
            recyclerProduct.layoutAnimation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_right_to_left)
            productAdapter.notifyDataSetChanged()
        }
    }
}