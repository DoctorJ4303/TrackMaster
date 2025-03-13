package org.crabcraft.trackmaster.data.repository

import kotlinx.coroutines.flow.Flow
import org.crabcraft.trackmaster.data.dao.AthleteDao
import org.crabcraft.trackmaster.model.Athlete

class AthleteRepository(private val athleteDao: AthleteDao) {
    fun getAllAthletes(): Flow<List<Athlete>> = athleteDao.getAllAthletes()
    fun getAthleteById(id: Int): Flow<Athlete> = athleteDao.getAthleteById(id)
    suspend fun insert(athlete: Athlete) = athleteDao.insert(athlete)
    suspend fun update(athlete: Athlete) = athleteDao.update(athlete)
    suspend fun delete(athlete: Athlete) = athleteDao.delete(athlete)
}