package com.github.studtravel.domain.model


class Room(
    val id: String,
    val universityId: String,
    val timestamp: Long,
    val dataRangeDto: DataRange,
    val amount: Double,
    val price: Double,
    val type: String,
    val photos: List<String>
)
