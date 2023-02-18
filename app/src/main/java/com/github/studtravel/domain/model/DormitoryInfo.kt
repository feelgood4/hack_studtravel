package com.github.studtravel.domain.model

class DormitoryInfo(
    val name: String,
    val city: String,
    val longitude: Double?,
    val latitude: Double?,
    val maxDays: String,
    val street: String,
    val houseNumber: String,
    val photos: List<String>,
)
