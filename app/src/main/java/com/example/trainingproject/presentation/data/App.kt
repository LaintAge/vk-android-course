package com.example.trainingproject.presentation.data

data class App(
    val id: Int,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int = 0,
    val size: Float = 0.0f,
    val iconUrl: String,
    val screenshotUrlList: List<String> = listOf(),
    val description: String,
    val showcase: List<App> = listOf()
)