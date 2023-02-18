package com.github.studtravel.presentation.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.github.studtravel.R

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

  companion object {
    const val SPLASH_SCREEN_TIME_OUT = 1500L
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash_screen)
    loadData()
  }

  private fun loadData() {
    Handler(Looper.getMainLooper()).postDelayed({
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }, SPLASH_SCREEN_TIME_OUT)
  }
}