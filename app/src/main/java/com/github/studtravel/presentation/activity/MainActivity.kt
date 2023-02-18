package com.github.studtravel.presentation.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.studtravel.R
import com.github.studtravel.databinding.ActivityMainBinding
import com.github.studtravel.presentation.screen.interests.InterestsFragment
import com.github.studtravel.presentation.screen.login.LoginFragment
import com.github.studtravel.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
      WindowManager.LayoutParams.FLAG_FULLSCREEN)

    setContentView(R.layout.activity_main)

    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val userIsAuthorized = viewModel.userIsLoggedIn
    val currentStartFragment = if (userIsAuthorized) InterestsFragment() else LoginFragment()

    supportFragmentManager
      .beginTransaction()
      .replace(R.id.rootFragmentContainer, currentStartFragment, "startFragment").commit()
  }
}
