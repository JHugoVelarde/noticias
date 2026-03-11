# NoticiasApp 🚀

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-blue.svg?style=for-the-badge&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-2024.09.00-4285F4?style=for-the-badge&logo=jetpackcompose)

NoticiasApp es una aplicación nativa para Android desarrollada con los más altos estándares y recomendaciones de arquitectura moderna (2026). Inspirada en el diseño editorial de JetNews, esta aplicación consume datos reales en tiempo real sobre la industria aeroespacial.

El objetivo principal de este repositorio es servir como referencia para el desarrollo moderno en Android, demostrando la integración de **Clean Architecture**, **MVVM**, y **Unidirectional Data Flow (UDF)** utilizando Jetpack Compose y las últimas bibliotecas de la comunidad.



## ✨ Características Principales

* **Interfaz de Usuario Declarativa:** Construida 100% con Jetpack Compose.
* **Diseño Moderno:** Soporte nativo para *Edge-to-Edge* (pantalla completa) y sistema de diseño Material Design 3.
* **Navegación Segura:** Implementación de *Type-Safe Navigation* mediante `kotlinx.serialization`, eliminando el enrutamiento frágil basado en Strings.
* **Consumo de API REST:** Conexión a la [Spaceflight News API](https://api.spaceflightnewsapi.net/v4/docs/) (gratuita y de código abierto).
* **Carga de Imágenes Eficiente:** Integración del nuevo motor multiplataforma de **Coil 3** con `OkHttpNetworkFetcher` y animaciones *crossfade*.
* **Gestión de Estados Reactiva:** Uso de `StateFlow` para manejar los estados de la interfaz (Loading, Success, Error).
* **Tipografía Personalizada:** Integración asíncrona de Google Fonts (Montserrat y Domine) mediante fuentes descargables.

## 🛠️ Stack Tecnológico

El proyecto está configurado con **API 36** (Target) y **API 26** (Min), utilizando el catálogo de versiones `libs.versions.toml`:

* **Lenguaje:** [Kotlin 2.0.21](https://kotlinlang.org/) (con K2 Compiler)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
* **Inyección de Dependencias:** [Dagger Hilt](https://dagger.dev/hilt/) (con KSP)
* **Red / Networking:** [Retrofit 2](https://square.github.io/retrofit/) + [OkHttp 3](https://square.github.io/okhttp/)
* **Serialización:** [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
* **Imágenes:** [Coil 3](https://coil-kt.github.io/coil/)
* **Arquitectura:** `ViewModel`, `StateFlow`, `SavedStateHandle`.

## 📂 Estructura del Proyecto

El código está organizado siguiendo los principios de **Clean Architecture**, separando las responsabilidades en capas claras (Data, Domain, UI):

```text
com.example.noticias
│
├── di/                     # Módulos de inyección de dependencias (Hilt)
│   ├── NetworkModule.kt    # Provisión de Retrofit, OkHttp y serializadores
│   └── RepositoryModule.kt # Conexión de interfaces con implementaciones
│
├── data/                   # Capa de datos y lógica de negocio
│   ├── model/              # Modelos de dominio (Article)
│   ├── remote/             # DTOs de red y definición de API (Retrofit)
│   └── repository/         # Implementación real (y fakes) del repositorio
│
├── navigation/             # Definición de rutas y Host de navegación Type-Safe
│
└── ui/                     # Capa de presentación (Compose)
    ├── theme/              # Color, Type, y Theme de Material 3
    └── screens/            # Pantallas de la aplicación
        ├── home/           # Lista de noticias (Screen, ViewModel, State)
        └── detail/         # Detalle del artículo (Screen, ViewModel, State)
