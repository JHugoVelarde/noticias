package com.example.noticias.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data class ArticleDetailRoute(val articleId: String)