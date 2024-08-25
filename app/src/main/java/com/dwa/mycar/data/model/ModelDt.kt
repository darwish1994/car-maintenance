package com.dwa.mycar.data.model

import com.google.gson.annotations.SerializedName

data class ModelDt(
    @SerializedName("brand")
    val brand: String,
    @SerializedName("models")
    val models: List<String>
)
