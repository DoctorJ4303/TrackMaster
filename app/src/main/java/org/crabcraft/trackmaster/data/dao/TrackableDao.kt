package org.crabcraft.trackmaster.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable


interface TrackableDao<T> {
    @Insert
    suspend fun insert(trackable: T)
    @Update
    suspend fun update(trackable: T)
    @Delete
    suspend fun delete(trackable: T)
}