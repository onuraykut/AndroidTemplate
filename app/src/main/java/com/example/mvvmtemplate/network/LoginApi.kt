package com.example.mvvmtemplate.network

import com.example.mvvmtemplate.model.CarListResult
import retrofit2.http.POST
//her ekran için ayrı service interface i yazılacak
interface LoginApi {
    @POST("cars.php")
    suspend fun getCars(): List<CarListResult>
}