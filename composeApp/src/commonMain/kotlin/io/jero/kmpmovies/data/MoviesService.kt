package io.jero.kmpmovies.data

import io.jero.kmpmovies.RemoteResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesService(
    val apiKey: String,
    val client: HttpClient
)

suspend fun MoviesService.fetchPopularMovies(): RemoteResult =
    client.get("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=$apiKey")
        .body<RemoteResult>()
