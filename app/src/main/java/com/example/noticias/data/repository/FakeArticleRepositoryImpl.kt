package com.example.noticias.data.repository

import com.example.noticias.data.model.Article
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeArticleRepositoryImpl @Inject constructor() : ArticleRepository {

    private val fakeArticles = listOf(
        Article(
            id = "1",
            title = "Novedades en Jetpack Compose 2026",
            subtitle = "La evolución del desarrollo nativo.",
            author = "Google Android Team",
            thumbnailUrl = "https://developer.android.com/images/social/compose-main.png",
            content = "Contenido extenso sobre Compose...",
            date = "Feb 26, 2026"
        ),
        Article(
            id = "2",
            title = "Kotlin 2.0.21: Rendimiento extremo",
            subtitle = "K2 compiler es ahora el estándar.",
            author = "JetBrains",
            thumbnailUrl = "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png",
            content = "Análisis técnico de las mejoras de compilación...",
            date = "Feb 20, 2026"
        )
    )

    override suspend fun getArticles(): List<Article> {
        delay(500)
        return fakeArticles
    }

    override suspend fun getArticleById(id: String): Article? {
        delay(300)
        return fakeArticles.find { it.id == id }
    }
}