package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class DormitoryInfoDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("coordinates")
    val coordinates: CoordinatesDto,
    @SerializedName("maxDays")
    val maxDays: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("houseNumber")
    val houseNumber: String,
    @SerializedName("photos")
    val photos: List<String>,
)
