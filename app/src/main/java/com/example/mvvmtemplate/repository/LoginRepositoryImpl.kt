package com.example.mvvmtemplate.repository

import com.example.mvvmtemplate.model.CarListResult
import com.example.mvvmtemplate.network.LoginApi
import com.example.mvvmtemplate.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginApi: LoginApi) :
    BaseRepository(), LoginRepository {

    override suspend fun carList(
        scope: CoroutineScope,
        onSuccess: ((List<CarListResult>?) -> Unit),
        onErrorAction: ((String?) -> Unit),
    ): Flow<Resource<CarListResult>> {
        return flow {
            sendRequest(
                scope = scope,
                client = { loginApi.getCars() },
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