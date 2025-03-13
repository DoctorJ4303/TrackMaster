package org.crabcraft.trackmaster.data

import android.content.Context
import androidx.room.Room
import org.crabcraft.trackmaster.data.AppDatabase

object DatabaseProvider {
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "trackmaster-database"
        ).build()
    }
}