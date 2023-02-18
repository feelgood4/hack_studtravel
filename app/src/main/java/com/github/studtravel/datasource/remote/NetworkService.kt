package com.github.studtravel.datasource.remote

import com.github.studtravel.data.service.INetworkService
import com.github.studtravel.datasource.remote.api.StudTravelApi
import com.github.studtravel.datasource.remote.model.ArticleDto
import com.github.studtravel.datasource.remote.model.DormitoryDto
import com.github.studtravel.datasource.remote.model.UniversityDto
import com.github.studtravel.domain.model.Article
import com.github.studtravel.domain.model.Dormitory
import com.github.studtravel.domain.model.University
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkService(
    private val studTravelApi: StudTravelApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : INetworkService {
    override suspend fun getArticles(): List<ArticleDto> = withContext(dispatcher) {
        studTravelApi.getArticles()
    }

    override suspend fun getUniversities(): List<UniversityDto> = withContext(dispatcher) {
        studTravelApi.getAllUniversities()
    }

    override suspend fun getDormitories(): List<DormitoryDto> = withContext(dispatcher) {
        studTravelApi.getAllDormitories()
    }
}
