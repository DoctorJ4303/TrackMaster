package org.crabcraft.trackmaster.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.crabcraft.trackmaster.data.dao.AthleteDao
import org.crabcraft.trackmaster.data.dao.WorkoutDao
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout

@Database(entities = [Athlete::class, Workout::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun athleteDao(): AthleteDao
    abstract fun workoutDao(): WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}