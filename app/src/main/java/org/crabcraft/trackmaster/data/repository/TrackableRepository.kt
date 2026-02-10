package org.crabcraft.trackmaster.data.repository

import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.data.dao.AthleteDao
import org.crabcraft.trackmaster.data.dao.WorkoutDao
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout

class AthleteRepository(private val athleteDao: AthleteDao) {
    fun getAllAthletes(): Flow<List<Athlete>> = athleteDao.getAllAthletes()
    fun getAthleteById(id: Int): Flow<Athlete> = athleteDao.getAthleteById(id)
    suspend fun insert(athlete: Athlete) = athleteDao.insert(athlete)
    suspend fun update(athlete: Athlete) = athleteDao.update(athlete)
    suspend fun delete(athlete: Athlete) = athleteDao.delete(athlete)
}

class WorkoutRepository (private val workoutDao: WorkoutDao) {
    fun getAllWorkouts(): Flow<List<Workout>> = workoutDao.getAllWorkouts()
    fun getWorkoutById(id: Int): Flow<Workout> = workoutDao.getWorkoutById(id)
    suspend fun insert(workout: Workout) = workoutDao.insert(workout)
    suspend fun update(workout: Workout) = workoutDao.update(workout)
    suspend fun delete(workout: Workout) = workoutDao.delete(workout)
}