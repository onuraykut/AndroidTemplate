package com.example.mvvmtemplate.utils

import android.util.Log

object CommonLog {

    fun exception(e: Exception, tag: String? = "Exception") {
        if (isDebug()) {
            Log.e("EX-|$tag", "Exception", e)
        }
    }

    fun exception(t: Throwable, tag: String? = "Exception") {
        if (isDebug()) {
            Log.e("EX-|$tag", "Exception", t)
        }
    }

    fun w(tag: String, message: String) {
        if (isDebug()) {
            Log.w("EX-|$tag", message)
        }
    }

    fun e(tag: String, message: String) {
        if (isDebug()) {
            Log.e("EX-|$tag", message)
        }
    }

    fun d(tag: String, message: String) {
        if (isDebug()) {
            Log.d("EX-|$tag", message)
        }
    }

    fun i(tag: String, message: String) {
        if (isDebug()) {
            Log.i("EX-|$tag", message)
        }
    }

    fun v(tag: String, message: String) {
        if (isDebug()) {
            Log.v("EX-|$tag", message)
        }
    }
}