package io.jero.kmpmovies.ui.screens.detail

import io.jero.kmpmovies.data.Movie

class DetailViewContract {
    data class UiState(
        val isLoading: Boolean = false,
        val movie: Movie? = null
    )
}