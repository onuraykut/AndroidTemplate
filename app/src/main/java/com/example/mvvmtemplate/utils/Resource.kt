package com.example.mvvmtemplate.utils


sealed class Resource<out T> {

    object Loading : Resource<Nothing>()

    object Empty : Resource<Nothing>()

    data class Success<out T>(val data: T) : Resource<T>()

    data class Failure(
        val errorMessage: String?,
    ) : Resource<Nothing>()
}