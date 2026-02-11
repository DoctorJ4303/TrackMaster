package org.crabcraft.trackmaster.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout


@Dao
interface WorkoutDao {
    @Insert
    suspend fun insert(workout: Workout)
    @Update
    suspend fun update(workout: Workout)
    @Delete
    suspend fun delete(workout: Workout)
    @Query("SELECT * FROM workouts")
    fun getAllWorkouts(): Flow<List<Workout>>

    @Query("SELECT * FROM workouts WHERE uid = :uid")
    fun getWorkoutById(uid: Int): Flow<Workout>
}

@Dao
interface AthleteDao {
    @Insert
    suspend fun insert(athlete: Athlete)
    @Update
    suspend fun update(athlete: Athlete)
    @Delete
    suspend fun delete(athlete: Athlete)
    @Query("SELECT * FROM athletes")
    fun getAllAthletes(): Flow<List<Athlete>>

    @Query("SELECT * FROM athletes WHERE uid = :uid")
    fun getAthleteById(uid: Int): Flow<Athlete>
}
