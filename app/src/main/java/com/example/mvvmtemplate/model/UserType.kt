package com.example.mvvmtemplate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserType(
    @SerializedName("celebrities")
    val list: List<Celebrity>
) : Serializable
