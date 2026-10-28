package com.example.trainingproject.data.applist

import com.example.trainingproject.domain.appdetails.Category

data class ShowcaseAppDto (
    val id: String,
    val name: String,
    val icon: String,
    val category: Category,
    val description: String,
)