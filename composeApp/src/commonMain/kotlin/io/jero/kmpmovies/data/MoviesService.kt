package io.jero.kmpmovies.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesService(
    val client: HttpClient
)

suspend fun MoviesService.fetchPopularMovies(): RemoteResult =
    client.get("/3/discover/movie?sort_by=popularity.desc").body<RemoteResult>()

suspend fun MoviesService.fetchMovieById(movieId: Int): RemoteMovie = client.get("/3/movie/$movieId").body<RemoteMovie>()