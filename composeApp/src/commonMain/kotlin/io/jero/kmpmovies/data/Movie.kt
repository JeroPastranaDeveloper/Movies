package io.jero.kmpmovies.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
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