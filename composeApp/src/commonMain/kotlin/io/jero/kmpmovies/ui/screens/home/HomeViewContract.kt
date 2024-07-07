package io.jero.kmpmovies.ui.screens.home

import io.jero.kmpmovies.data.Movie

class HomeViewContract {
    data class UiState(
        val isLoading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}