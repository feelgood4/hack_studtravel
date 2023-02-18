package com.github.studtravel.datasource.remote

import com.github.studtravel.datasource.remote.api.StudTravelApi
import com.github.studtravel.datasource.remote.model.ArticleDto
import com.github.studtravel.datasource.remote.model.UniversityDto

class NetworkService(private val studTravelApi: StudTravelApi) {
    suspend fun getArticles(): List<ArticleDto>  = studTravelApi.getArticles()

    suspend fun getUniversities(): List<UniversityDto> = studTravelApi.getAllUniversities()


}
