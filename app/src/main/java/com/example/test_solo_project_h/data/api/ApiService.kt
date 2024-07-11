package com.example.test_solo_project_h.data.api

import com.example.test_solo_project_h.data.dto.Characters
import com.example.test_solo_project_h.utils.Constants
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getCharacters() : Characters



}