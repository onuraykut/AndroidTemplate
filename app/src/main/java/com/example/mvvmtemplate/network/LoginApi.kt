package com.example.mvvmtemplate.network

import com.example.mvvmtemplate.model.CelebritiesResult
import retrofit2.http.GET

//her ekran için ayrı service interface i yazılacak
interface LoginApi {
    @GET("61928e23-1cd7-4e1c-915a-dda4d8e7e64f")
    suspend fun getCelebrities(): CelebritiesResult
}