package com.example.mvvmtemplate.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.mvvmtemplate.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel@Inject constructor(
    app: Application
) : AndroidViewModel(app) {

    val loadingDetection by lazy { SingleLiveEvent<Boolean>() }
}