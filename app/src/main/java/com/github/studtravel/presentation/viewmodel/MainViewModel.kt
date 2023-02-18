package com.github.studtravel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.studtravel.datasource.remote.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkService: NetworkService
): ViewModel() {

    fun getArticles() {
        viewModelScope.launch {
            val ss = networkService.getArticles()
            val s = ss
        }
    }
}
