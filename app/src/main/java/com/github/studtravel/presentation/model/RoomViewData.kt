package com.github.studtravel.presentation.model


class RoomViewData(
    val id: String,
    val universityId: String,
    val timestamp: Long,
    val dataRange: DataRangeViewData?,
    val amount: Double,
    val price: Double,
    val type: String,
    val photos: List<String>
)
