package io.jero.kmpmovies.data.repository

import io.jero.kmpmovies.data.Movie
import io.jero.kmpmovies.data.RemoteMovie

fun RemoteMovie.toDomain() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w500$posterPath"
)