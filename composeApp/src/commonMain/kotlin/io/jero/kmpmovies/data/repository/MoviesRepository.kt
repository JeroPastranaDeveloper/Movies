package io.jero.kmpmovies.data.repository

import io.jero.kmpmovies.data.Movie
import io.jero.kmpmovies.data.MoviesService
import io.jero.kmpmovies.data.fetchMovie
import io.jero.kmpmovies.data.fetchPopularMovies

class MoviesRepository(private val moviesService: MoviesService) {
    suspend fun fetchPopularMovies(): List<Movie> = moviesService.fetchPopularMovies().results.map { it.toDomain() }
    suspend fun fetchMovieById(movieId: Int): Movie = moviesService.fetchMovie(movieId).toDomain()
}