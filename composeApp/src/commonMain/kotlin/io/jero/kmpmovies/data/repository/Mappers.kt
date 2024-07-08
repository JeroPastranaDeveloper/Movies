package io.jero.kmpmovies.data.repository

import io.jero.kmpmovies.data.Movie
import io.jero.kmpmovies.data.RemoteMovie

fun RemoteMovie.toDomain() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w185$posterPath",
    overview = overview,
    releaseDate = releaseDate,
    backDrop = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" },
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    popularity = popularity,
    voteAverage = voteAverage
)