package com.example.test_solo_project_h.data.repository

import com.example.test_solo_project_h.data.api.ApiService
import com.example.test_solo_project_h.data.dto.Characters
import com.example.test_solo_project_h.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val apiService: ApiService):
    RickMortyRepository {
    override suspend fun getCharacters(): Characters = apiService.getCharacters()

}