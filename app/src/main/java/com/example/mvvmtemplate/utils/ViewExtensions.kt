package com.example.mvvmtemplate.utils

import android.view.View


fun View.visibleIf(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
