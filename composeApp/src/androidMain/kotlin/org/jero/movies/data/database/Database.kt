package org.jero.movies.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import io.jero.kmpmovies.data.room.database.DATABASE_NAME
import io.jero.kmpmovies.data.room.database.MoviesDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MoviesDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)

    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath
    )
}