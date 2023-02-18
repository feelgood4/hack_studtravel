package com.github.studtravel.domain.repository

import com.github.studtravel.domain.model.Dormitory

interface IDormitoryRepository {
    suspend fun getAllDormitories(): List<Dormitory>
}
