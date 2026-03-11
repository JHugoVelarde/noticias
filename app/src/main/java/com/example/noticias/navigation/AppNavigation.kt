package com.example.noticias.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noticias.ui.screens.detail.ArticleDetailScreen
import com.example.noticias.ui.screens.detail.ArticleDetailViewModel
import com.example.noticias.ui.screens.home.HomeScreen
import com.example.noticias.ui.screens.home.HomeViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        // 1. Destino: Inicio
        composable<HomeRoute> {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = homeViewModel,
                onArticleClick = { articleId ->
                    // Navegamos pasando la clase de datos, ¡Type-Safe!
                    navController.navigate(ArticleDetailRoute(articleId))
                }
            )
        }

        // 2. Destino: Detalle
        composable<ArticleDetailRoute> {
            val detailViewModel: ArticleDetailViewModel = hiltViewModel()
            ArticleDetailScreen(
                viewModel = detailViewModel,
                onBackClick = {
                    navController.navigateUp() // Vuelve a la pantalla anterior
                }
            )
        }
    }
}