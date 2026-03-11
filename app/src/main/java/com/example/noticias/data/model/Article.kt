package com.example.noticias.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val thumbnailUrl: String,
    val content: String,
    val date: String
)
