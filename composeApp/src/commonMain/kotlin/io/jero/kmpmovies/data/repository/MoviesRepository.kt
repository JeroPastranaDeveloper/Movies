package io.jero.kmpmovies.data.repository

import io.jero.kmpmovies.data.Movie
import io.jero.kmpmovies.data.MoviesService
import io.jero.kmpmovies.data.fetchMovieById
import io.jero.kmpmovies.data.fetchPopularMovies
import io.jero.kmpmovies.data.room.database.MoviesDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class MoviesRepository(
    private val moviesService: MoviesService,
    private val moviesDao: MoviesDao
) {
    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies().onEach { movies ->
        if (movies.isEmpty()) {
            val popularMovies = moviesService.fetchPopularMovies().results.map { it.toDomain() }
            moviesDao.save(popularMovies)
        }
    }

    suspend fun fetchMovieById(movieId: Int): Flow<Movie?> =
        moviesDao.fetchMovieById(movieId).onEach { movie ->
            movie?.let {
                val remoteMovie = moviesService.fetchMovieById(movieId).toDomain()
                moviesDao.save(listOf(remoteMovie))
            }
        }
}
