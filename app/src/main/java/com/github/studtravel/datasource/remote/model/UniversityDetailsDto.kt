package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class UniversityDetailsDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("photo")
    val image: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("committee")
    val committee: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("region")
    val region: String
)
