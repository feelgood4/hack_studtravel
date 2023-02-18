package com.github.studtravel.datasource.login

import com.github.studtravel.datasource.login.model.Result
import com.github.studtravel.datasource.remote.model.LoggedInUser
import com.github.studtravel.domain.repository.ILoginRepository
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository @Inject constructor(private val dataSource: LoginDataSource) : ILoginRepository {


  private var isLogged: Boolean = false
    private set

  var userData: LoggedInUser? = null
    private set

  init {
    isLogged = dataSource.checkLoginStatus()
  }

  override suspend fun logout() {
    isLogged = false
    dataSource.logout()
  }

  override fun isLoggedIn(): Boolean {
    return isLogged
  }

  override suspend fun login(username: String, password: String): Result<LoggedInUser> {
    val result = dataSource.login(username, password)
    if (result is Result.Success) {
      setLoggedInUser(result.data)
    }

    return result
  }

  private fun setLoggedInUser(loggedInUser: LoggedInUser) {
    this.userData = loggedInUser
  }
}