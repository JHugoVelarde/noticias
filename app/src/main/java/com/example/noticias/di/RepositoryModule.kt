package com.example.noticias.di

import com.example.noticias.data.repository.ArticleRepository
import com.example.noticias.data.repository.NetworkArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindArticleRepository(
        // impl: FakeArticleRepositoryImpl
        impl: NetworkArticleRepositoryImpl
    ): ArticleRepository
}