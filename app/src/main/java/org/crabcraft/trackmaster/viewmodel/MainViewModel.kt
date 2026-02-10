package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.util.UIState

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<UIState>(UIState.Workout)
    val uiState: StateFlow<UIState> = _uiState

    private val _trackables = MutableStateFlow<MutableList<Trackable>>(mutableListOf())
    val trackables: StateFlow<MutableList<Trackable>> = _trackables

    fun toggleMode(state: UIState) {
        _uiState.value = when (state) {
            is UIState.Workout -> UIState.Athlete
            is UIState.Athlete -> UIState.Workout
        }
    }
}