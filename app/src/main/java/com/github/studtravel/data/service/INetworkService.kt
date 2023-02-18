package com.github.studtravel.data.service

import com.github.studtravel.datasource.remote.model.ArticleDto
import com.github.studtravel.datasource.remote.model.DormitoryDto
import com.github.studtravel.datasource.remote.model.UniversityDto

interface INetworkService {
    suspend fun getArticles(): List<ArticleDto>
    suspend fun getUniversities(): List<UniversityDto>
    suspend fun getDormitories(): List<DormitoryDto>
}
