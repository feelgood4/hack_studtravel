package com.github.studtravel.presentation.viewmodel

import android.util.Log
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
import com.github.studtravel.presentation.mapper.toViewData
import com.github.studtravel.presentation.model.DormitoryViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val dormitoryRepository: IDormitoryRepository,
  private val loginRepository: ILoginRepository
) : ViewModel() {

  private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    Log.d("NetworkError", "Error message")
  }

  private val _loginForm = MutableLiveData<LoginFormState>()
  val loginFormState: LiveData<LoginFormState> = _loginForm

  private val _loginResult = MutableLiveData<LoginResult>()
  val loginResult: LiveData<LoginResult> = _loginResult

  private val _dormitories = MutableLiveData<List<DormitoryViewData>>()
  val dormitories: LiveData<List<DormitoryViewData>> = _dormitories

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

  fun getAllDormitories(){
    viewModelScope.launch(exceptionHandler) {
      val newList = dormitoryRepository.getAllDormitories()
      _dormitories.value = newList.map { it.toViewData() }
    }
  }
}
