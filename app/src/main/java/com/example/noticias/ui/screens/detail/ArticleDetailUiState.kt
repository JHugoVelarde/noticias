package com.example.noticias.ui.screens.detail

import com.example.noticias.data.model.Article

sealed interface ArticleDetailUiState {
    data object Loading : ArticleDetailUiState
    data class Success(val article: Article) : ArticleDetailUiState
    data class Error(val message: String) : ArticleDetailUiState
}