package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.data.repository.WorkoutRepository
import org.crabcraft.trackmaster.model.Workout

class WorkoutViewModel(private val workoutRepository: WorkoutRepository) : ViewModel() {

    val allWorkouts: Flow<List<Workout>> = workoutRepository.getAllWorkouts()

    fun insertWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.insert(workout)
        }
    }

    fun updateWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.update(workout)
        }
    }

    fun deleteWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.delete(workout)
        }
    }
}