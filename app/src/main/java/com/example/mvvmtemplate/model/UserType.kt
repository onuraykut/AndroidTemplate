package com.example.mvvmtemplate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserType(
    @SerializedName("celebrities")
    var list: List<Celebrity>
) : Serializable
