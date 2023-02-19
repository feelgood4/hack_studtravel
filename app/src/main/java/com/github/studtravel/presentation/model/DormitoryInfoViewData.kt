package com.github.studtravel.presentation.model

data class DormitoryInfoViewData(
    val name: String,
    val city: String,
    val longitude: Double?,
    val latitude: Double?,
    val maxDays: String,
    val street: String,
    val houseNumber: String,
    val photos: List<String>,
)
