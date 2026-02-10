package org.crabcraft.trackmaster.data

import android.content.Context
import org.crabcraft.trackmaster.data.repository.AthleteRepository
import org.crabcraft.trackmaster.data.repository.WorkoutRepository

interface AppContainer {
    val athleteRepository: AthleteRepository
    val workoutRepository: WorkoutRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val athleteRepository: AthleteRepository by lazy {
        AthleteRepository(TrackMasterDatabase.getDatabase(context).athleteDao())
    }
    override val workoutRepository: WorkoutRepository by lazy {
        WorkoutRepository(TrackMasterDatabase.getDatabase(context).workoutDao())
    }
}