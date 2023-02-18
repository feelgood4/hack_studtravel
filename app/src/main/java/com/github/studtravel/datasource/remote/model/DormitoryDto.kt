package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class DormitoryDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("universityId")
    val universityId: String,
    @SerializedName("rooms")
    val rooms: Map<String, RoomDto>,
    @SerializedName("details")
    val details: DormitoryDetailsDto
)
