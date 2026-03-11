package com.example.noticias.ui.screens.home

import com.example.noticias.data.model.Article

/**
 * Representa los estados posibles de la pantalla de inicio.
 * Usamos una interfaz sellada para garantizar que solo manejemos estados válidos.
 */
sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val articles: List<Article>,
        val isRefreshing: Boolean = false
    ) : HomeUiState

    data class Error(val message: String) : HomeUiState
}