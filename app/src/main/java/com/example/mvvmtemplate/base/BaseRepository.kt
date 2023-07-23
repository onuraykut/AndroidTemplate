package com.example.mvvmtemplate.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

open class BaseRepository {
    fun <T> sendRequest(
        scope: CoroutineScope,
        client: suspend () -> T,
        onErrorAction: ((String?) -> Unit)?,
        onSuccess: ((T) -> Unit),
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        loginRequired: Boolean = true
    ) {
        makeAPIRequest(scope, client, onSuccess, onErrorAction, dispatcher, loginRequired)
    }

    private fun <T> makeAPIRequest(
        scope: CoroutineScope,
        client: suspend () -> T,
        onSuccess: ((T) -> Unit)? = null,
        onErrorAction: ((String?) -> Unit)? = null,
        dispatcher: CoroutineDispatcher,
        loginRequired: Boolean
    ) {
        scope.launch {
            try {
                val request = flow {
                    emit(client)
                }.flowOn(dispatcher)

                request.catch { e ->
                    onErrorAction?.invoke(e.message)
                }.collect {
                    onSuccess?.invoke(it.invoke())
                }
            } catch (e: Exception) {
                onErrorAction?.invoke(e.message)
            }
        }
    }
}