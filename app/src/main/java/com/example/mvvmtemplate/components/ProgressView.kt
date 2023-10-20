package com.example.mvvmtemplate.components

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.animation.RotateAnimation
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.mvvmtemplate.R

class ProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var anim: RotateAnimation? = null
    private val imageView: ImageView

    init {
        val typedArray = attrs?.let { getContext().obtainStyledAttributes(attrs, R.styleable.ProgressView) }
        val hasShadow = typedArray?.getBoolean(R.styleable.ProgressView_apv_hasShadow, true) ?: true
        typedArray?.recycle()

        if (hasShadow) setBackgroundResource(R.drawable.background_progress)

        imageView = ImageView(context).apply {
            layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER)
            setImageResource(R.drawable.icon_qnb_blue)
            scaleType = ImageView.ScaleType.CENTER
        }
        addView(imageView)
    }
}