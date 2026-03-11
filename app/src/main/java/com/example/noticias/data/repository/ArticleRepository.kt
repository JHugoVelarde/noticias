package com.example.noticias.data.repository

import com.example.noticias.data.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
    suspend fun getArticleById(id: String): Article?
}