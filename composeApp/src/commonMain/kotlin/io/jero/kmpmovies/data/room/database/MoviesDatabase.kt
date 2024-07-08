package io.jero.kmpmovies.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.jero.kmpmovies.data.Movie

const val DATABASE_NAME = "movies.db"

fun interface DB {
    fun clearAllTables()
}

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDatabase: RoomDatabase(), DB {
    abstract fun moviesDao(): MoviesDao

    override fun clearAllTables() { /* Nothing */ }
}