package com.example.mvvmtemplate.network

import com.example.mvvmtemplate.model.CelebritiesResult
import retrofit2.http.GET

//her ekran için ayrı service interface i yazılacak
interface LoginApi {
    @GET("963ba137-d294-46bb-84f8-b5dcc8d760a8")
    suspend fun getCelebrities(): List<CelebritiesResult>
}