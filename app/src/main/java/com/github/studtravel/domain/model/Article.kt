package com.github.studtravel.domain.model

class Article(
    val id: String,
    val userId: String,
    val title: String,
    val tags: List<String>,
    val timestamp: Long,
    val content: String,
    val image: String
)
