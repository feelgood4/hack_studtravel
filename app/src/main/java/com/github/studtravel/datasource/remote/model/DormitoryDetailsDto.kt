package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class DormitoryDetailsDto(
    @SerializedName("main-info")
    val info: DormitoryInfoDto
)
