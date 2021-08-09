package com.example.animationapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonScale.setOnClickListener {
            val animationScale = AnimationUtils.loadAnimation(this, R.anim.scale)
            textScale.startAnimation(animationScale)
        }

        buttonAlpha.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
            textAlpha.startAnimation(animation)
        }

        textTranslate.setOnClickListener {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()
        }

        buttonRotate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            textRotate.startAnimation(animation)
        }

        buttonTranslate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.translate)
            textTranslate.startAnimation(animation)
        }

        buttonSet.setOnClickListener {
            val animationScale = AnimationUtils.loadAnimation(this, R.anim.scale)
            val animationAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha)
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)

            val animationSet = AnimationSet(true).apply {
                interpolator = AccelerateInterpolator()
                addAnimation(animationScale)
                addAnimation(animationAlpha)
                addAnimation(animationRotate)
            }
            textSet.startAnimation(animationSet)
        }

        buttonCart.setOnClickListener {
            Intent(this, CartViewActivity::class.java).also {
                startActivity(it)
            }
        }

        buttonDrawable.setOnClickListener {
            Intent(this, DrawableActivity::class.java).also {
                startActivity(it)
            }
        }

        buttonProperty.setOnClickListener {
            Intent(this, InterpolatorActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}