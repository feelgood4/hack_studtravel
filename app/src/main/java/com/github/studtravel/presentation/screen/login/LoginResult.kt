package com.github.studtravel.presentation.screen.login

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
  val success: LoggedInUserView? = null,
  val error: Int? = null
)