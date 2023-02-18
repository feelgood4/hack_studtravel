package com.github.studtravel.datasource.remote.api

import com.github.studtravel.datasource.remote.model.ArticleDto
import com.github.studtravel.datasource.remote.model.DormitoryDto
import com.github.studtravel.datasource.remote.model.UniversityDto
import com.github.studtravel.domain.model.Article
import com.github.studtravel.domain.model.Dormitory
import com.github.studtravel.domain.model.University
import retrofit2.http.GET
import retrofit2.http.Path

interface StudTravelApi {
    @GET("articles")
    suspend fun getArticles(): List<ArticleDto>

    @GET("universities/all")
    suspend fun getAllUniversities(): List<UniversityDto>

    @GET("universities/{id}")
    suspend fun getUniversity(@Path("id") id: String): UniversityDto

    @GET("dormitories/all")
    suspend fun getAllDormitories(): List<DormitoryDto>
}
