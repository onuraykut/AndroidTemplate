package com.example.mvvmtemplate.extensions

import android.content.Context
import android.util.TypedValue

fun Context.convertDPtoPX(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.resources.displayMetrics)
}