package com.github.studtravel.domain.repository

interface IPreferencesRepository {
  suspend fun saveLoginState(userName: String)
  suspend fun resetLoginState()

  fun checkLoginStatus(): Boolean
}