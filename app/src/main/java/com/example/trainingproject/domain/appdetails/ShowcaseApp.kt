package com.example.trainingproject.domain.appdetails

data class ShowcaseApp (
    val id: String,
    val name: String,
    val iconUrl: String,
    val category: Category,
    val description: String,
)