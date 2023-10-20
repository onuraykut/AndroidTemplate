package com.example.mvvmtemplate.components

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.mvvmtemplate.extensions.convertDPtoPX

class ProgressDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val progressView = ProgressView(context)
        setContentView(progressView)
        progressView.layoutParams.width = context.convertDPtoPX(85f).toInt()
        progressView.layoutParams.height = context.convertDPtoPX(85f).toInt()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
    }
}