package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.data.repository.TrackMasterRepository
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.model.Workout
import org.crabcraft.trackmaster.util.UIState

class MainViewModel(private val repository: TrackMasterRepository): ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Workout)
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    private val _athletes = MutableStateFlow<List<Athlete>>(emptyList())
    val athletes: StateFlow<List<Athlete>> = _athletes.asStateFlow()

    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts.asStateFlow()

    init {
        viewModelScope.launch { repository.getAllAthletes().collect { _athletes.value = it } }
        viewModelScope.launch { repository.getAllWorkouts().collect { _workouts.value = it } }
    }

    fun setUIState(state: UIState) { _uiState.value = state }

    fun createTrackable() {
        viewModelScope.launch {
            when (_uiState.value) {
                is UIState.Workout -> repository.insert(Workout(name = "New Workout"))
                is UIState.Athlete -> repository.insert(Athlete(name = "New Athlete"))
            }
        }
    }

    fun removeTrackable(trackable: Trackable) {
        viewModelScope.launch {
            when (trackable) {
                is Workout -> repository.delete(trackable)
                is Athlete -> repository.delete(trackable)
            }
        }
    }
}