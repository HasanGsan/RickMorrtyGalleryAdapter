package com.example.test_solo_project_h.ui.viewmodel

import com.example.test_solo_project_h.domain.model.RickMortyModel


data class RickMortyStates(
    val load: Boolean = false,
    val success: List<RickMortyModel> = emptyList(),
    val fail: String = ""
)
