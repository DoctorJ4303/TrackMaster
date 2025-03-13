package org.crabcraft.trackmaster.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.model.Athlete

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