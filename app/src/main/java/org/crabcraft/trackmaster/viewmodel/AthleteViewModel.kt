package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.data.repository.AthleteRepository
import org.crabcraft.trackmaster.model.Athlete

class AthleteViewModel(private val athleteRepository: AthleteRepository) : ViewModel() {

    val allAthletes: Flow<List<Athlete>> = athleteRepository.getAllAthletes()

    fun insertAthlete(athlete: Athlete) {
        viewModelScope.launch {
            athleteRepository.insert(athlete)
        }
    }

    fun updateAthlete(athlete: Athlete) {
        viewModelScope.launch {
            athleteRepository.update(athlete)
        }
    }

    fun deleteAthlete(athlete: Athlete) {
        viewModelScope.launch {
            athleteRepository.delete(athlete)
        }
    }
}