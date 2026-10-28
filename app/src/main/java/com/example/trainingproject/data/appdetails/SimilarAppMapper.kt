package com.example.trainingproject.data.appdetails

import com.example.trainingproject.domain.appdetails.SimilarApp

class SimilarAppMapper {
    fun toDomain(dto: SimilarAppDto): SimilarApp = SimilarApp(
        id = dto.id,
        name = dto.name,
        iconUrl = dto.iconUrl,
    )
}