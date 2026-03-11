package com.example.noticias.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// La API devuelve un objeto que contiene una lista llamada "results"
@Serializable
data class NetworkArticleResponse(
    val results: List<NetworkArticle>
)

// Este es el artículo tal y como viene de internet
@Serializable
data class NetworkArticle(
    val id: Int, // Esta API usa números para los IDs
    val title: String,
    val summary: String,
    @SerialName("news_site") val newsSite: String,
    @SerialName("image_url") val imageUrl: String,
    @SerialName("published_at") val publishedAt: String
)