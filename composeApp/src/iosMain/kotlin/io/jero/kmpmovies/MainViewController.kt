package io.jero.kmpmovies

import androidx.compose.ui.window.ComposeUIViewController
import io.jero.kmpmovies.room.database.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController {
    val database = getDatabaseBuilder().build()
    App(database.moviesDao())
}