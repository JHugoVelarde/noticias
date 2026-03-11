package com.example.noticias.data.repository

import com.example.noticias.data.model.Article
import com.example.noticias.data.remote.NewsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkArticleRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
):  ArticleRepository {

    private var cachedArticles = listOf<Article>()

    override suspend fun getArticles(): List<Article> {
        /* Anterior código
        return newsApi.getArticles()*/
        // 1. Llamamos a la API real
        val response = newsApi.getArticles()

        // 2. Mapeamos (Convertimos) NetworkArticle a nuestro Article de Dominio
        cachedArticles = response.results.map { networkObj ->
            Article(
                id = networkObj.id.toString(), // Convertimos el Int a String
                title = networkObj.title,
                subtitle = networkObj.summary,
                author = networkObj.newsSite,
                thumbnailUrl = networkObj.imageUrl,
                content = networkObj.summary, // Usamos el resumen como contenido
                date = networkObj.publishedAt.take(10) // Tomamos solo la fecha (YYYY-MM-DD), ignorando la hora
            )
        }

        // 3. Devolvemos la lista ya formateada para nuestra UI
        return cachedArticles
    }

    override suspend fun getArticleById(id: String): Article? {
        /* Anterior código
        return newsApi.getArticles().find { it.id == id }*/
        return cachedArticles.find { it.id == id }
    }
}