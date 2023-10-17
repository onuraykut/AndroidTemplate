
package com.example.mvvmtemplate.di

import com.example.mvvmtemplate.network.LoginApi
import com.example.mvvmtemplate.repository.LoginRepository
import com.example.mvvmtemplate.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CelebrityModule {

    @Provides
    @Singleton
    internal fun provideCarListRepository(service: LoginApi): LoginRepository =
        LoginRepositoryImpl(service)
}
