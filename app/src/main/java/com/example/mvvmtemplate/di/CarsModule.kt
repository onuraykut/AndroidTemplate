package com.example.mvvmtemplate.di

import com.example.mvvmtemplate.network.LoginApi
import com.example.mvvmtemplate.repository.LoginRepository
import com.example.mvvmtemplate.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarsModule {

    @Provides
    @Singleton
    internal fun provideEndPointService(
        retrofit: Retrofit,
    ): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    @Singleton
    internal fun provideCarListRepository(service: LoginApi): LoginRepository =
        LoginRepositoryImpl(service)
}