package com.example.trainingproject.data.applist

import com.example.trainingproject.domain.applist.ShowcaseApp

class ShowcaseAppMapper {
    fun toDomain(dto: ShowcaseAppDto): ShowcaseApp = ShowcaseApp(
        id = dto.id,
        name = dto.name,
        iconUrl = dto.icon,
        category = dto.category,
        description = dto.description,
    )
}