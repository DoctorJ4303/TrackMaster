package org.crabcraft.trackmaster.data.repository

import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.data.dao.AthleteDao
import org.crabcraft.trackmaster.data.dao.WorkoutDao
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout

class TrackMasterRepository(private val database: TrackMasterDatabase) {
    fun getAllAthletes(): Flow<List<Athlete>> = database.athleteDao().getAllAthletes()
    fun getAthleteById(id: Int): Flow<Athlete> = database.athleteDao().getAthleteById(id)
    suspend fun insert(athlete: Athlete) = database.athleteDao().insert(athlete)
    suspend fun delete(athlete: Athlete) = database.athleteDao().delete(athlete)

    fun getAllWorkouts(): Flow<List<Workout>> = database.workoutDao().getAllWorkouts()
    fun getWorkoutById(id: Int): Flow<Workout> = database.workoutDao().getWorkoutById(id)
    suspend fun insert(workout: Workout) = database.workoutDao().insert(workout)
    suspend fun delete(workout: Workout) = database.workoutDao().delete(workout)
}