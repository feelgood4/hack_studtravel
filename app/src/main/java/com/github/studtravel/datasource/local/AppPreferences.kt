package com.github.studtravel.datasource.local

import android.content.Context
import com.github.studtravel.domain.repository.IPreferencesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPreferences @Inject constructor(@ApplicationContext private val context: Context) : IPreferencesRepository {
  override suspend fun saveUserInterests(interests: List<String>) {
    val prefs = context.getSharedPreferences(APP_PREF_KEY, Context.MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putStringSet(USER_INTERESTS_PREF_KEY, interests.toSet())
    editor.apply()
  }

  fun saveLoginState(userName: String) {
    val prefs = context.getSharedPreferences(APP_PREF_KEY, Context.MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString(USERNAME_PREF_KEY, userName)
    editor.apply()
  }

  fun checkLoginStatus(): Boolean {
    val prefs = context.getSharedPreferences(APP_PREF_KEY, Context.MODE_PRIVATE)
    return prefs.getString(USERNAME_PREF_KEY, null) != null
  }

  fun resetLoginState() {
    val prefs = context.getSharedPreferences(APP_PREF_KEY, Context.MODE_PRIVATE)
    val editor = prefs.edit()
    editor.remove(USERNAME_PREF_KEY)
    editor.remove(USER_INTERESTS_PREF_KEY)
    editor.apply()
  }
}

private const val APP_PREF_KEY = "studTravelPrefKey"
private const val USERNAME_PREF_KEY = "loggedUserName"
private const val USER_INTERESTS_PREF_KEY = "userInterests"