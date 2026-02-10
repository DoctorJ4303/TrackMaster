package org.crabcraft.trackmaster.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.crabcraft.trackmaster.data.dao.AthleteDao
import org.crabcraft.trackmaster.data.dao.WorkoutDao
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout

@Database(entities = [Athlete::class, Workout::class], version = 1, exportSchema = false)
abstract class TrackMasterDatabase : RoomDatabase() {
    abstract fun athleteDao(): AthleteDao
    abstract fun workoutDao(): WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: TrackMasterDatabase? = null

        fun getDatabase(context: Context): TrackMasterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrackMasterDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}