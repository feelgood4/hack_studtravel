package com.github.studtravel.datasource.login

import com.github.studtravel.datasource.local.AppPreferences
import com.github.studtravel.datasource.login.model.Result
import com.github.studtravel.datasource.remote.model.LoggedInUser
import java.io.IOException
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.delay

class LoginDataSource @Inject constructor(private val appPreferences: AppPreferences) {

  suspend fun login(username: String, password: String): Result<LoggedInUser> {
    return try {
      // simulate a request to the server
      delay(2000L)
      appPreferences.saveLoginState(username)
      val userData = LoggedInUser(UUID.randomUUID().toString(), username)
      Result.Success(userData)
    } catch (e: Throwable) {
      Result.Error(IOException("Error logging in", e))
    }
  }

  suspend fun logout(): Result<Boolean> {
    return try {
      delay(1000L)
      appPreferences.resetLoginState()
      Result.Success(true)
    } catch (e: Throwable) {
      Result.Error(IOException("Error logout", e))
    }
  }

  fun checkLoginStatus(): Boolean {
    return try {
      val isLogged = appPreferences.checkLoginStatus()
      isLogged
    } catch (e: Throwable) {
      false
    }
  }
}