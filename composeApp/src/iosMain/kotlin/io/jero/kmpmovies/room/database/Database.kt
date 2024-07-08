package io.jero.kmpmovies.room.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.jero.kmpmovies.data.room.database.DATABASE_NAME
import io.jero.kmpmovies.data.room.database.MoviesDatabase
import io.jero.kmpmovies.data.room.database.instantiateImpl
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<MoviesDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder<MoviesDatabase>(
        name = dbFilePath,
        factory = { MoviesDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}