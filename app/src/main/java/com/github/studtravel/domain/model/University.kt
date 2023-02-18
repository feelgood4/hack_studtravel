package com.github.studtravel.domain.model


class University(
    val id: String,
    val name: String,
    val details: UniversityDetails,
    val userId: String,
    val onModeration: Boolean,
    val timestamp: Long,
)
