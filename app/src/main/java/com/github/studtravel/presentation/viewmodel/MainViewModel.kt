package com.github.studtravel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.studtravel.domain.repository.IDormitoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dormitoryRepository: IDormitoryRepository
) : ViewModel() {

    fun getArticles() {
        viewModelScope.launch {
            val ss = dormitoryRepository.getAllDormitories()
            val s = ss
        }
    }
}
