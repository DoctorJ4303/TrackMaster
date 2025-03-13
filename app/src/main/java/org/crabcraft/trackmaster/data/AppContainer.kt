package org.crabcraft.trackmaster.data

import android.content.Context
import org.crabcraft.trackmaster.data.repository.AthleteRepository
import org.crabcraft.trackmaster.data.repository.WorkoutRepository
import org.crabcraft.trackmaster.viewmodel.AthleteViewModel
import org.crabcraft.trackmaster.viewmodel.WorkoutViewModel

interface AppContainer {
    val athleteRepository: AthleteRepository
    val workoutRepository: WorkoutRepository
    val athleteViewModel: AthleteViewModel
    val workoutViewModel: WorkoutViewModel
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val athleteRepository: AthleteRepository by lazy {
        AthleteRepository(AppDatabase.getDatabase(context).athleteDao())
    }
    override val workoutRepository: WorkoutRepository by lazy {
        WorkoutRepository(AppDatabase.getDatabase(context).workoutDao())
    }
    override val athleteViewModel: AthleteViewModel by lazy {
        AthleteViewModel(athleteRepository)
    }
    override val workoutViewModel: WorkoutViewModel by lazy {
        WorkoutViewModel(workoutRepository)
    }
}