package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class DataRangeDto(
    @SerializedName("from")
    val from: Long,
    @SerializedName("to")
    val to: Long
)
