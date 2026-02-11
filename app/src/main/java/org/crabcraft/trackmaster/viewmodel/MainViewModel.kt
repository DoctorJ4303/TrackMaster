package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.model.Workout
import org.crabcraft.trackmaster.util.UIState

class MainViewModel(private val database: TrackMasterDatabase): ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Workout)
    val uiState: StateFlow<UIState> = _uiState
    private val _athletes = MutableStateFlow<List<Athlete>>(emptyList())
    val athletes: StateFlow<List<Athlete>> = _athletes
    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts

    init {
        viewModelScope.launch { database.workoutDao().getAllWorkouts().collect { _workouts.value = it } }
        viewModelScope.launch { database.athleteDao().getAllAthletes().collect { _athletes.value = it } }
    }

    fun setUIState(state: UIState) { _uiState.value = state }

    fun createTrackable() {
        viewModelScope.launch {
            when (_uiState.value) {
                is UIState.Workout -> database.workoutDao().insert(Workout(name = "New Workout"))
                is UIState.Athlete -> database.athleteDao().insert(Athlete(name = "New Athlete"))
            }
        }
    }

    fun removeTrackable(trackable: Trackable) {
        viewModelScope.launch {
            when (_uiState.value) {
                is UIState.Workout -> database.workoutDao().delete(trackable as Workout)
                is UIState.Athlete -> database.athleteDao().delete(trackable as Athlete)
            }
        }
    }
}