package com.example.mvvmtemplate.ui.cars

import com.example.mvvmtemplate.repository.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val carsRepository: LoginRepository
) : BaseViewModel() {


    init {
    }
}