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

    fun getCelebrityList() = viewModelScope.launch {
        _onCelebList.value = Resource.Loading
        repository.celebrityList(
            viewModelScope,
            onSuccess = {
                //listeyi bas
                Log.i("TAG", "response: $it")
                _onCelebList.value = Resource.Success(it)
            },
            onErrorAction = {
                // hata mesajı bas
                _onCelebList.value = Resource.Failure(it)
            }
        )
    }

    fun redirectCelebrityDetail(celebrity: Celebrity) {

    }


    init {

    }
}