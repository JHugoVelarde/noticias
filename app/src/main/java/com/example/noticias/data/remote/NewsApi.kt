package com.example.noticias.data.remote

import com.example.noticias.data.model.Article
import retrofit2.http.GET

interface NewsApi {
    // Pedimos los últimos 20 artículos
    @GET("articles/?limit=20")
    suspend fun getArticles(): NetworkArticleResponse
}