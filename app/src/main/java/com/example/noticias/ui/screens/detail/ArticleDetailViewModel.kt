package com.example.noticias.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.noticias.data.repository.ArticleRepository
import com.example.noticias.navigation.ArticleDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val repository: ArticleRepository,
    savedStateHandle: SavedStateHandle // Hilt inyecta esto automáticamente
) : ViewModel() {

    private val _uiState = MutableStateFlow<ArticleDetailUiState>(ArticleDetailUiState.Loading)
    val uiState: StateFlow<ArticleDetailUiState> = _uiState.asStateFlow()

    init {
        // ¡Navegación moderna! Extraemos el objeto de ruta directamente
        val route = savedStateHandle.toRoute<ArticleDetailRoute>()
        fetchArticle(route.articleId)
    }

    private fun fetchArticle(id: String) {
        viewModelScope.launch {
            _uiState.value = ArticleDetailUiState.Loading
            try {
                val article = repository.getArticleById(id)
                if (article != null) {
                    _uiState.value = ArticleDetailUiState.Success(article)
                } else {
                    _uiState.value = ArticleDetailUiState.Error("Artículo no encontrado")
                }
            } catch (e: Exception) {
                _uiState.value = ArticleDetailUiState.Error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }
}