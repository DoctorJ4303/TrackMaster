package org.crabcraft.trackmaster.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    fun provideDatabase(context: Context): TrackMasterDatabase {
        return Room.databaseBuilder(
            context,
            TrackMasterDatabase::class.java,
            "trackmaster-database"
        ).build()
    }
}