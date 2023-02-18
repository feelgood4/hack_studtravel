package com.github.studtravel.data.repository

import com.github.studtravel.data.service.INetworkService
import com.github.studtravel.datasource.mapper.toData
import com.github.studtravel.domain.model.Dormitory
import com.github.studtravel.domain.repository.IDormitoryRepository
import javax.inject.Inject

class DormitoryRepository @Inject constructor(
    private val networkService: INetworkService
) : IDormitoryRepository {
    override suspend fun getAllDormitories(): List<Dormitory> =
        networkService.getDormitories().map { it.toData() }
}
