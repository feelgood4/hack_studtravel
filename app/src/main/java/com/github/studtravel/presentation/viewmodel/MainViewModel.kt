package com.github.studtravel.presentation.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.studtravel.R
import com.github.studtravel.datasource.login.model.Result
import com.github.studtravel.presentation.screen.login.LoggedInUserView
import com.github.studtravel.presentation.screen.login.LoginFormState
import com.github.studtravel.presentation.screen.login.LoginResult
import com.github.studtravel.domain.repository.IDormitoryRepository
import com.github.studtravel.domain.repository.ILoginRepository
import com.github.studtravel.domain.repository.IPreferencesRepository
import com.github.studtravel.presentation.screen.interests.model.Interest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class MainViewModel @Inject constructor(
  private val dormitoryRepository: IDormitoryRepository,
  private val loginRepository: ILoginRepository,
  private val preferencesRepository: IPreferencesRepository
) : ViewModel() {

  private val _loginForm = MutableLiveData<LoginFormState>()
  val loginFormState: LiveData<LoginFormState> = _loginForm

  private val _loginResult = MutableLiveData<LoginResult>()
  val loginResult: LiveData<LoginResult> = _loginResult

  val userIsLoggedIn
    get() = loginRepository.isLoggedIn()

  fun login(username: String, password: String) {
    viewModelScope.launch {
      val result = loginRepository.login(username, password)

      if (result is Result.Success) {
        _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
      } else {
        _loginResult.value = LoginResult(error = R.string.login_failed)
      }
    }
  }

  fun loginDataChanged(username: String, password: String) {
    if (!isUserNameValid(username)) {
      _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
    } else if (!isPasswordValid(password)) {
      _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
    } else {
      _loginForm.value = LoginFormState(isDataValid = true)
    }
  }

  private fun isUserNameValid(username: String): Boolean {
    return if (username.contains("@")) {
      Patterns.EMAIL_ADDRESS.matcher(username).matches()
    } else {
      username.isNotBlank()
    }
  }

  private fun isPasswordValid(password: String): Boolean {
    return password.length > 5
  }

  fun saveUserInterests(interests: List<Interest>) {
    val result = interests.filter { it.isChecked }
    viewModelScope.launch(Dispatchers.IO) {
      preferencesRepository.saveUserInterests(emptyList())
    }
  }

  fun getArticles() {
    viewModelScope.launch {
      val ss = dormitoryRepository.getAllDormitories()
      val s = ss
    }
  }
}
