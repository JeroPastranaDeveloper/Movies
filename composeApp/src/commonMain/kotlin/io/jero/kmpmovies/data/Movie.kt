package io.jero.kmpmovies.data

data class Movie(
    val id: Int = 0,
    val title: String = "",
    val poster: String = "",
    val overview: String = "",
    val releaseDate: String = "",
    val backDrop: String? = null,
    val originalTitle: String = "",
    val originalLanguage: String = "",
    val popularity: Double = 0.0,
    val voteAverage: Double = 0.0
)