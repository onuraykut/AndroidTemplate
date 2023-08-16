package com.example.mvvmtemplate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Celebrity(
    @SerializedName("name_surname")
    val nameSurname: String,
    @SerializedName("age")
    val age: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("image")
    val image: String
) : Serializable
