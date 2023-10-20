package com.example.mvvmtemplate.utils

import android.util.Range
import com.example.mvvmtemplate.BuildConfig

fun isDebug(): Boolean {
    return BuildConfig.DEBUG
}

inline fun Boolean?.ifTrue(block: () -> Unit) {
    if (this == true) {
        block()
    }
}

inline fun Boolean?.ifFalse(block: () -> Unit) {
    if (this == false || this == null) {
        block()
    }
}

inline fun Boolean?.castToString(): String {
    if (this != null && this) {
        return "1"
    }
    return "0"
}

inline fun Boolean?.castToYesNo(): String {
    if (this != null && this) {
        return "E"
    }
    return "H"
}

inline fun <T> tryCatch(action: () -> T?): T? = tryCatch(fallback = null, action = action)

inline fun <T> tryCatch(fallback: T?, action: () -> T?): T? {
    var value: T? = null
    try {
        value = action()
    } catch (t: Throwable) {
        CommonLog.exception(t)
    }
    return value ?: fallback
}

inline fun <reified T : Enum<T>> enumValueOfOptional(key: String, fallback: T?): T =
    tryCatch(fallback) { enumValueOf<T>(key) }!!

fun Int.isRange(min: Int, max: Int): Boolean {
    return Range<Int>(min, max).contains(this)
}