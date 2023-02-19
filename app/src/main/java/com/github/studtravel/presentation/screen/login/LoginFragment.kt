package com.github.studtravel.presentation.screen.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.studtravel.databinding.FragmentLoginBinding
import com.github.studtravel.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

  private val viewModel: MainViewModel by viewModels()
  private var _binding: FragmentLoginBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentLoginBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val usernameEditText = binding.username
    val passwordEditText = binding.password
    val loginButton = binding.login
    val skipButton = binding.skip
    val loadingProgressBar = binding.loading

    viewModel.loginFormState.observe(viewLifecycleOwner,
      Observer { loginFormState ->
        if (loginFormState == null) {
          return@Observer
        }
        loginButton.isEnabled = loginFormState.isDataValid
        loginFormState.usernameError?.let {
          usernameEditText.error = getString(it)
        }
        loginFormState.passwordError?.let {
          passwordEditText.error = getString(it)
        }
      })

    viewModel.loginResult.observe(viewLifecycleOwner,
      Observer { loginResult ->
        loginResult ?: return@Observer
        loadingProgressBar.visibility = View.GONE
        loginResult.error?.let {
          showLoginFailed(it)
        }
        loginResult.success?.let {
          updateUiWithUser(it)
        }
      })

    val afterTextChangedListener = object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        // ignore
      }

      override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        // ignore
      }

      override fun afterTextChanged(s: Editable) {
        viewModel.loginDataChanged(
          usernameEditText.text.toString(),
          passwordEditText.text.toString()
        )
      }
    }
    usernameEditText.addTextChangedListener(afterTextChangedListener)
    passwordEditText.addTextChangedListener(afterTextChangedListener)
    passwordEditText.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        viewModel.login(
          usernameEditText.text.toString(),
          passwordEditText.text.toString()
        )
      }
      false
    }

    loginButton.setOnClickListener {
      loadingProgressBar.visibility = View.VISIBLE
      viewModel.login(
        usernameEditText.text.toString(),
        passwordEditText.text.toString()
      )
    }

    skipButton.setOnClickListener {
      loadingProgressBar.visibility = View.INVISIBLE
      skipLogin()
    }
  }

  private fun skipLogin() {
    // TODO implement switch to main screen
  }

  private fun updateUiWithUser(model: LoggedInUserView) {
    // TODO implement switch to main screen
  }

  private fun showLoginFailed(@StringRes errorString: Int) {
    val appContext = context?.applicationContext ?: return
    Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
