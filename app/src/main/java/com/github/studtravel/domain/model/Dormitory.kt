package com.github.studtravel.domain.model

class Dormitory(
    val id: String,
    val timestamp: Long,
    val universityId: String,
    val rooms: List<Room>,
    val info: DormitoryInfo?
)
