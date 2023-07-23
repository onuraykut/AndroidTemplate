package com.example.mvvmtemplate.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.HttpException

// todo. naming will be doing and this code will move to upper side
fun <T> Flow<T>.exceptionHandler(): Flow<T> {
    return this.catch {
        if (it is HttpException) {
            if (!arrayListOf(403, 406, 422).contains(it.code())) {
                throw it
            }
        }
    }
}