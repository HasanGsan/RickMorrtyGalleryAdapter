package com.example.test_solo_project_h.domain.repository

import com.example.test_solo_project_h.data.dto.Characters

interface RickMortyRepository {
    suspend fun getCharacters() : Characters
}