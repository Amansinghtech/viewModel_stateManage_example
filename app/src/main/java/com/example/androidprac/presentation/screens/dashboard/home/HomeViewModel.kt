package com.example.androidprac.presentation.screens.dashboard.home

import androidx.lifecycle.ViewModel
import com.example.androidprac.core.data.repositories.topCategories.TopCategoriesRepo
import com.example.androidprac.core.models.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

sealed class TopCategoriesUiState {
    data object Idle : TopCategoriesUiState()
    data class Loading(val progress: Float = 0f) : TopCategoriesUiState()
    data class Success(val data: List<CategoryModel>) : TopCategoriesUiState()
    data class Error(val message: String) : TopCategoriesUiState()
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val topCategoriesRepo: TopCategoriesRepo
) : ViewModel() {
    private var _topCategoriesUiState =
        MutableStateFlow<TopCategoriesUiState>(TopCategoriesUiState.Idle)

    val topCategoriesUiState = _topCategoriesUiState.asStateFlow()

    suspend fun getTopCategories() {
        try {
            loadingMock()
            val categories = topCategoriesRepo.getAllTopCategories()
            _topCategoriesUiState.value = TopCategoriesUiState.Success(categories)

        } catch (error: Error) {
            _topCategoriesUiState.value = TopCategoriesUiState.Error("Something Went Wrong!")
        }
    }

    private suspend fun loadingMock() {
        var progress = 0f
        while (progress < 1f) {
            _topCategoriesUiState.value = TopCategoriesUiState.Loading(progress = progress)
            delay(100)
            progress += 0.1f
        }

    }
}