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
interface AthleteDao : TrackableDao<Athlete> {
    @Query("SELECT * FROM workouts")
    fun getAllAthletes(): Flow<List<Athlete>>

    @Query("SELECT * FROM workouts WHERE uid = :uid")
    fun getAthleteById(uid: Int): Flow<Athlete>
}