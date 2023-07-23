package com.example.mvvmtemplate.repository

import com.example.mvvmtemplate.model.CarListResult
import com.example.mvvmtemplate.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun carList(
        scope: CoroutineScope,
        onSuccess: ((List<CarListResult>?) -> Unit),
        onErrorAction: ((String?) -> Unit)
    ) : Flow<Resource<CarListResult>>
}