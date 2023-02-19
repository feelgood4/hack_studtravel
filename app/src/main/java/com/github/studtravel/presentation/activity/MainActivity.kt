package com.github.studtravel.presentation.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.studtravel.R
import com.github.studtravel.databinding.ActivityMainBinding
import com.github.studtravel.presentation.screen.login.LoginFragment
import com.github.studtravel.presentation.screen.main_search.MainTabFragment
import com.github.studtravel.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userIsAuthorized = viewModel.userIsLoggedIn
        val currentStartFragment = if (userIsAuthorized) MainTabFragment() else LoginFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.rootFragmentContainer, currentStartFragment, "startFragment")
            .commit()

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> setCurrentFragment(MainTabFragment())
                R.id.events -> setCurrentFragment(MainTabFragment())
                R.id.achives -> setCurrentFragment(MainTabFragment())
                R.id.routes -> setCurrentFragment(MainTabFragment())
                R.id.profile -> setCurrentFragment(MainTabFragment())
            }
            true
        }
    }

    fun showNavBottom() {
        binding.navView.visibility = View.VISIBLE
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.rootFragmentContainer, fragment)
            commit()
        }
}
