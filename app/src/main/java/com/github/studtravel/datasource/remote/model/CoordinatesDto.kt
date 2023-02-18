package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class CoordinatesDto(
    @SerializedName("lat")
    val latitude: String?,
    @SerializedName("lng")
    val longitude: String?
)
