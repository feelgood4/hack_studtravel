package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class RoomDetailsDto(
    @SerializedName("dataRange")
    val dataRange: DataRangeDto?,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("photos")
    val photos: List<String>,
    @SerializedName("description")
    val description: String
)
