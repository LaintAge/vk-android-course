package com.example.trainingproject.data.applist

import kotlinx.serialization.Serializable

@Serializable
data class ShowcaseAppDto (
    val id: String,
    val name: String,
    val iconUrl: String,
    val category: String,
    val description: String,
)