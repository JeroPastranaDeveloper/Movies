package io.jero.kmpmovies.ui.screens.home

import io.jero.kmpmovies.RemoteMovie
import io.jero.kmpmovies.data.Movie

fun RemoteMovie.toDomain() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w500$posterPath"
)