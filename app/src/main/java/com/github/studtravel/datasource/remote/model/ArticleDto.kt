package com.github.studtravel.datasource.remote.model

import com.google.gson.annotations.SerializedName

class ArticleDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("content")
    val content: String,
    @SerializedName("cover")
    val image: String
)
