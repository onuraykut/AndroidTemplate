package com.example.mvvmtemplate.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.mvvmtemplate.utils.SingleLiveEvent

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    val loadingDetection by lazy { SingleLiveEvent<Boolean>() }

    /*val exceptionHandler = CoroutineExceptionHandler { _, e ->
        when (e) {
            is SocketTimeoutException,
            is SSLHandshakeException,
            is SSLPeerUnverifiedException,
            is UnknownHostException,
            is MalformedURLException,
            is ConnectException -> {
                dialog {
                    type = DialogType.SYSTEM_ERROR
                    titleResId = R.string.error_title
                    contentResId = R.string.connect_error_description
                }
            }
            is HttpException -> {
                val errorModel = e.parseException()

                if (errorModel?.message.isNullOrEmpty()) {
                    dialog {
                        type = DialogType.FAIL_ERROR
                        titleResId = R.string.error_title
                        contentResId = R.string.generic_error_description
                    }
                } else {
                    dialog {
                        type = DialogType.FAIL_ERROR
                        contentText = errorModel?.message
                    }
                }
            }
            else -> {
                e.message?.let {
                    dialog {
                        type = DialogType.FAIL_ERROR
                        titleResId = R.string.error_title
                        contentText = it
                    }
                } ?: run {
                    dialog {
                        type = DialogType.FAIL_ERROR
                        titleResId = R.string.error_title
                        contentResId = R.string.generic_error_description
                    }
                }
            }
        }
    }*/
}