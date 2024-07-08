package io.jero.kmpmovies.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jero.kmpmovies.data.repository.MoviesRepository
import io.jero.kmpmovies.ui.screens.home.HomeViewContract.UiState
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MoviesRepository) : ViewModel() {
    var state by mutableStateOf(UiState())

    init {
        viewModelScope.launch {
            state = UiState(
                isLoading = true
            )

            repository.movies.collect { movies ->
                if (movies.isNotEmpty()) {
                    state = UiState(
                        movies = movies,
                        isLoading = false
                    )
                }
            }
        }
    }
}
