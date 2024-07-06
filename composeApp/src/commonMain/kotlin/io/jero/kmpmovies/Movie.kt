package io.jero.kmpmovies

data class Movie(
    val id: Int,
    val title: String,
    val poster: String
)

val movies = (1..100).map {
    Movie(
        id = it,
        title = "Movie $it",
        "https://picsum.photos/200/300?id=$it"
    )
}