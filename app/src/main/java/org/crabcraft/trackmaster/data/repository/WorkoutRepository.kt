package org.crabcraft.trackmaster.data.repository

import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.data.dao.WorkoutDao
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout

class WorkoutRepository (private val workoutDao: WorkoutDao) {
    fun getAllWorkouts(): Flow<List<Workout>> = workoutDao.getAllWorkouts()
    fun getWorkoutById(id: Int): Flow<Workout> = workoutDao.getWorkoutById(id)
    suspend fun insert(workout: Workout) = workoutDao.insert(workout)
    suspend fun update(workout: Workout) = workoutDao.update(workout)
    suspend fun delete(workout: Workout) = workoutDao.delete(workout)
}