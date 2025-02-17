package org.crabcraft.trackmaster.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.util.CurrentUIState

class MainViewModel :ViewModel() {
    private val uiState = MutableLiveData<CurrentUIState>()

    init {
        setUIState(CurrentUIState.Workout(onClick = {
            setUIState(CurrentUIState.Athlete().icons.copy(onClick = {}))
        }))
    }

    private fun setUIState(state: CurrentUIState) {
        viewModelScope.launch {
            uiState.value = state
        }
    }

    fun getWorkoutState(): @Composable () -> Unit {
        when(uiState.value) {
            is CurrentUIState.Workout -> {
                println((uiState.value as CurrentUIState.Workout).icons.selectedIcon)
                return (uiState.value as CurrentUIState.Workout).icons.selectedIcon
            }

            is CurrentUIState.Athlete ->
                return (uiState.value as CurrentUIState.Athlete).icons.unselectedIcon

            else ->
                return {}
        }
    }

    fun getAthleteState(): @Composable () -> Unit {
        when(uiState.value) {
            is CurrentUIState.Workout ->
                return (uiState.value as CurrentUIState.Workout).icons.unselectedIcon

            is CurrentUIState.Athlete ->
                return (uiState.value as CurrentUIState.Athlete).icons.selectedIcon

            else ->
                return {}
        }
    }

    fun getIconState(): Int {
        return when(uiState.value) {
            is CurrentUIState.Workout ->
                (uiState.value as CurrentUIState.Workout).icon

            is CurrentUIState.Athlete ->
                (uiState.value as CurrentUIState.Athlete).icon

            else ->
                0
        }
    }

    fun getTitleState(): String {
        return when(uiState.value) {
            is CurrentUIState.Workout ->
                (uiState.value as CurrentUIState.Workout).title

            is CurrentUIState.Athlete ->
                (uiState.value as CurrentUIState.Athlete).title

            else ->
                ""
        }
    }
}