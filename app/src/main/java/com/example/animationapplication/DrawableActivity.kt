package com.example.animationapplication

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_drawable.*

class DrawableActivity : AppCompatActivity() {

    private lateinit var batteryAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)

        imageBattery.apply {
            setBackgroundResource(R.drawable.animation_battery)
            batteryAnimation = background as AnimationDrawable
            setOnClickListener {
                batteryAnimation.start()
            }
        }
    }
}