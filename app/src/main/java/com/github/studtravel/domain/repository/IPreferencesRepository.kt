package com.github.studtravel.domain.repository

interface IPreferencesRepository {
  suspend fun saveUserInterests(interests: List<String>)
}