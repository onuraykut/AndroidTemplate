package com.example.mvvmtemplate.ui.celebrity

import android.app.Application
import android.provider.Settings.Global
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvvmtemplate.base.BaseViewModel
import com.example.mvvmtemplate.model.Celebrity
import com.example.mvvmtemplate.repository.LoginRepository
import com.example.mvvmtemplate.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    myApp: Application
) : BaseViewModel(app = myApp) {

    private val _onCelebList = MutableStateFlow<Resource<List<Celebrity>>>(Resource.Empty)
    val onCelebList: StateFlow<Resource<List<Celebrity>>> = _onCelebList

    fun getCelebrityList() = viewModelScope.launch {
        //loading
        repository.celebrityList(
            viewModelScope,
            onSuccess = {
                //listeyi bas
                        Log.i("TAG", "response: $it")
            },
            onErrorAction = {
                // hata mesajı bas
            }
        )
    }

    init {

    }
}