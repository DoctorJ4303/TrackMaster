package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.util.CurrentUIState

class MainViewModel :ViewModel() {
    private val _uiState = MutableLiveData<CurrentUIState>(CurrentUIState.Workout())
    val uiState: LiveData<CurrentUIState> = _uiState

    init {
        setUIState(CurrentUIState.Workout())
    }

    private fun setUIState(state: CurrentUIState) {
        viewModelScope.launch {
            when (state) {
                is CurrentUIState.Workout ->
                    _uiState.value = state.copy(onClick = {
                        println("ITS RUNNING")
                        setUIState(CurrentUIState.Athlete())
                    })

                is CurrentUIState.Athlete ->
                    _uiState.value = state.copy(onClick = {
                        println("ITS RUNNING")
                        setUIState(CurrentUIState.Workout())
                    })
            }
        }
    }
}