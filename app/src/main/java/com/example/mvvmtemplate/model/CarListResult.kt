package com.example.mvvmtemplate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CarListResult(
    @SerializedName("BrandName")
    val brandName: String,
    @SerializedName("MediumImageUrl")
    val mediumImageUrl: String,
    @SerializedName("ModelName")
    val modelName: String,
    @SerializedName("ModelYear")
    val modelYear: String,
    @SerializedName("Plate")
    val plate: String,
    @SerializedName("Price")
    val price: String
) : Serializable
