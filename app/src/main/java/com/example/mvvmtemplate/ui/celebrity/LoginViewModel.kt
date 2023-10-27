package com.example.mvvmtemplate.ui.celebrity

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvvmtemplate.base.BaseViewModel
import com.example.mvvmtemplate.model.CelebritiesResult
import com.example.mvvmtemplate.model.Celebrity
import com.example.mvvmtemplate.repository.LoginRepository
import com.example.mvvmtemplate.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    myApp: Application
) : BaseViewModel(app = myApp) {

    private val _onCelebList = MutableStateFlow<Resource<CelebritiesResult?>>(Resource.Empty)
    val onCelebList: StateFlow<Resource<CelebritiesResult?>> = _onCelebList

    private val _redirectCelebrityDetail = MutableStateFlow<Celebrity?>(null)
    val redirectCelebrityDetail: StateFlow<Celebrity?> = _redirectCelebrityDetail

    fun getCelebrityList() = viewModelScope.launch {
        _onCelebList.value = Resource.Loading
        repository.celebrityList(
            viewModelScope,
            onSuccess = {
                _onCelebList.value = Resource.Success(it)
            },
            onErrorAction = {
                _onCelebList.value = Resource.Failure(it)
            }
        )
    }

    fun redirectCelebrityDetail(celebrity: Celebrity) {
        _redirectCelebrityDetail.value = celebrity
    }


    init {

    }
}