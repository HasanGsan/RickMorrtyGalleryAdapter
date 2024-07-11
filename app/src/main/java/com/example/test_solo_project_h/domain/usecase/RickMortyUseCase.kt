package com.example.test_solo_project_h.domain.usecase

import com.example.test_solo_project_h.domain.model.RickMortyModel
import com.example.test_solo_project_h.domain.model.toDomain
import com.example.test_solo_project_h.domain.repository.RickMortyRepository
import com.example.test_solo_project_h.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickMortyUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke() : Flow<Resource<List<RickMortyModel>>> = flow{
        try{
            emit(Resource.Loading())
            val data = repository.getCharacters().results.map{it.toDomain()}
            emit(Resource.Success(data))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "no internet connection"))
        } catch (e: IOException){
            emit(Resource.Error("Error"))
        }
    }
}