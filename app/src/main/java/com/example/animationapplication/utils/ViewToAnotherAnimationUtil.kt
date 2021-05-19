package com.example.animationapplication.utils

import android.view.View
import android.view.animation.*
import android.widget.ImageView

object ViewToAnotherAnimationUtil {

    private const val ANIMATION_DURATION = 1000L
    private const val STEP_DURATION = 200L
    private var isAnimationStart = false

    fun translateAnimation(
        viewAnimation: ImageView,
        startView: View,
        endView: View,
        listener: Animation.AnimationListener?
    ) {
        val startViewBitmap = startView.getBitmapFromView()
        viewAnimation.setImageBitmap(startViewBitmap)

        val startViewWidthCenter = startView.width / 2f
        val startViewHeightCenter = startView.height / 2f

//            val endViewWidthCenter = endView.width / 2f
//            val endViewHeightCenter = endView.height / 2f

        val startPos = IntArray(2)
        startView.getLocationOnScreen(startPos)

        val endPos = IntArray(2)
        endView.getLocationOnScreen(endPos)

        val fromX = startPos[0] + 0.0f
        val toX = endPos[0] + 0.0f
        val fromY = startPos[1] + 0.0f
        val toY = endPos[1] + 0.0f

        val scaleAnimation =
            ScaleAnimation(
                1.0f,
                1.5f,
                1.0f,
                1.5f,
                startViewWidthCenter,
                startViewHeightCenter
            ).apply {
                duration = STEP_DURATION
            }

        val translateAnimation = TranslateAnimation(fromX, toX, fromY, toY).apply {
            startOffset = STEP_DURATION
            duration = ANIMATION_DURATION
        }

        val translateScaleAnimation = ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, toX, toY).apply {
            startOffset = STEP_DURATION
            duration = ANIMATION_DURATION
        }

        val animationSet = AnimationSet(true).apply {
            interpolator = AccelerateInterpolator()
            addAnimation(scaleAnimation)
            addAnimation(translateAnimation)
            addAnimation(translateScaleAnimation)
        }

        if (isAnimationStart) {
            viewAnimation.clearAnimation()
            listener?.onAnimationEnd(null)
        }

        viewAnimation.startAnimation(animationSet)

        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isAnimationStart = true

                viewAnimation.visibility = View.VISIBLE
                startView.visibility = View.INVISIBLE

                listener?.onAnimationStart(animation)
            }

            override fun onAnimationEnd(animation: Animation?) {
                viewAnimation.visibility = View.GONE
                startView.visibility = View.VISIBLE

                listener?.onAnimationEnd(animation)

                isAnimationStart = false
            }

            override fun onAnimationRepeat(animation: Animation?) {
                listener?.onAnimationRepeat(animation)
            }
        })
    }
}