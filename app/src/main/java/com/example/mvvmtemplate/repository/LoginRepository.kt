package com.example.mvvmtemplate.repository

import com.example.mvvmtemplate.model.CelebritiesResult
import com.example.mvvmtemplate.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun celebrityList(
        scope: CoroutineScope,
        onSuccess: ((List<CelebritiesResult>?) -> Unit),
        onErrorAction: ((String?) -> Unit)
    ) : Flow<Resource<CelebritiesResult>>
}