package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class CoordinatesDto(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)
