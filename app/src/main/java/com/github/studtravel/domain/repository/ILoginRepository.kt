package com.github.studtravel.domain.repository

import com.github.studtravel.datasource.login.model.Result
import com.github.studtravel.datasource.remote.model.LoggedInUser

interface ILoginRepository {
  suspend fun login(username: String, password: String): Result<LoggedInUser>
  suspend fun logout()
  fun isLoggedIn(): Boolean
}