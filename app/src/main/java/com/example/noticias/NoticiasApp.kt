package com.example.noticias

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import coil3.request.crossfade
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NoticiasApp : Application(), SingletonImageLoader.Factory {

    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context)
            .components {
                // Le conectamos el motor de internet a Coil
                add(OkHttpNetworkFetcherFactory())
            }
            .crossfade(true) // Agrega una animación suave al aparecer la imagen
            .build()
    }
}