package io.jero.kmpmovies.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jero.kmpmovies.data.repository.MoviesRepository
import io.jero.kmpmovies.ui.screens.detail.DetailViewContract.UiState
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieId: Int,
    private val repository: MoviesRepository
) : ViewModel() {
    var state by mutableStateOf(UiState())

    init {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            state = UiState(movie = repository.fetchMovieById(movieId), isLoading = false)
        }
    }
}