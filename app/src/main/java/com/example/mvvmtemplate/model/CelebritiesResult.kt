package com.example.mvvmtemplate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CelebritiesResult(
    @SerializedName("user_type")
    var userType: UserType
) : Serializable
