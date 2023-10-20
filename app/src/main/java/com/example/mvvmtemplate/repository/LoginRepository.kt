package com.example.mvvmtemplate.repository

import com.example.mvvmtemplate.base.BaseRepository
import com.example.mvvmtemplate.model.CelebritiesResult
import com.example.mvvmtemplate.network.LoginApi
import com.example.mvvmtemplate.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginApi: LoginApi) :
    BaseRepository() {
    suspend fun celebrityList(
        scope: CoroutineScope,
        onSuccess: ((CelebritiesResult?) -> Unit),
        onErrorAction: ((String?) -> Unit),
    ) =
        sendRequest(
            scope = scope,
            client = { loginApi.getCelebrities() },
            onSuccess = {
                onSuccess(it)
            },
            onErrorAction = {
                onErrorAction(it)
            }
        )
}