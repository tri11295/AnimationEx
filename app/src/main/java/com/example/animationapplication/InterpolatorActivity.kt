package com.example.animationapplication

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_interpolator.*


class InterpolatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolator)

        linear.setOnClickListener {
            ObjectAnimator.ofFloat(linear, "translationX",  300f).apply {
                interpolator = LinearInterpolator()
                duration = ANIMATION_DURATION
                start()
            }
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()
        }

        accelerate.setOnClickListener {
            ObjectAnimator.ofFloat(accelerate, "translationX", 300f).apply {
                interpolator = AccelerateInterpolator()
                duration = ANIMATION_DURATION
                start()
            }
        }

        decelerate.setOnClickListener {
            ObjectAnimator.ofFloat(decelerate, "translationX", 300f).apply {
                interpolator = DecelerateInterpolator()
                duration = ANIMATION_DURATION
                start()
            }
        }

        bounce.setOnClickListener {
            ObjectAnimator.ofFloat(bounce, "translationX", 300f).apply {
                interpolator = BounceInterpolator()
                duration = ANIMATION_DURATION
                start()
            }
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 3000L
    }
}