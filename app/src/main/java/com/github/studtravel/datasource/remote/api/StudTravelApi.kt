package com.github.studtravel.datasource.remote.api

import com.github.studtravel.datasource.remote.model.ArticleDto
import com.github.studtravel.datasource.remote.model.UniversityDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StudTravelApi {
    @GET("articles")
    suspend fun getArticles(): List<ArticleDto>

    @GET("universities/all")
    suspend fun getAllUniversities(): List<UniversityDto>

    @GET("universities/{id}")
    suspend fun getUniversity(@Path("id") id: String): UniversityDto
}
