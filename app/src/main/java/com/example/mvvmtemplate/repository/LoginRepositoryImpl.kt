package com.example.mvvmtemplate.repository

import com.example.mvvmtemplate.base.BaseRepository
import com.example.mvvmtemplate.model.CelebritiesResult
import com.example.mvvmtemplate.network.LoginApi
import com.example.mvvmtemplate.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginApi: LoginApi) :
    BaseRepository(), LoginRepository {

    override suspend fun celebrityList(
        scope: CoroutineScope,
        onSuccess: ((List<CelebritiesResult>?) -> Unit),
        onErrorAction: ((String?) -> Unit),
    ): Flow<Resource<CelebritiesResult>> {
        return flow {
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
    }

}