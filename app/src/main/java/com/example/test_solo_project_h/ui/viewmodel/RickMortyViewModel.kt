package com.example.test_solo_project_h.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_solo_project_h.domain.usecase.RickMortyUseCase
import com.example.test_solo_project_h.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(
    private val useCase: RickMortyUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(RickMortyStates())
    val state: MutableStateFlow<RickMortyStates> = _state

    init {
        getItems()
    }

    private fun getItems() = viewModelScope.launch(Dispatchers.IO) {
        useCase().collect {
            when (it) {
                is Resource.Success -> _state.value = RickMortyStates(success = it.data ?: emptyList())
                is Resource.Loading -> _state.value = RickMortyStates(load = true)
                is Resource.Error -> _state.value = RickMortyStates(fail = it.message ?: "error")
            }
        }
    }
}
