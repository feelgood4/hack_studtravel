package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class RoomDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("universityId")
    val universityId: String,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("details")
    val details: RoomDetailsDto
)
