package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class UniversityDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("details")
    val details: UniversityDetailsDto,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("onModeration")
    val onModeration: Boolean,
    @SerializedName("timestamp")
    val timestamp: Long,
)
