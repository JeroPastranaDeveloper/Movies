package io.jero.kmpmovies.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jero.kmpmovies.data.MoviesService
import io.jero.kmpmovies.data.fetchPopularMovies
import io.jero.kmpmovies.ui.screens.home.HomeViewContract.UiState
import kotlinx.coroutines.launch

class HomeViewModel(private val service: MoviesService) : ViewModel() {
    var state by mutableStateOf(UiState())

    init {
        viewModelScope.launch {
            state = UiState(
                isLoading = true
            )
            state = UiState(
                movies = service.fetchPopularMovies().results.map { it.toDomain() },
                isLoading = false
            )
        }
    }
}
