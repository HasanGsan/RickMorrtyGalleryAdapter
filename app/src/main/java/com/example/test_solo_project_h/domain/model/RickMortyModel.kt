package com.example.test_solo_project_h.domain.model

import com.example.test_solo_project_h.data.dto.Result


data class RickMortyModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toDomain()= RickMortyModel(
    created = created,
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    url = url
)