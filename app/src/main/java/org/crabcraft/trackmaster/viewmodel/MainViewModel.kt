package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.util.UIState

class MainViewModel :ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Workout())
    val uiState: LiveData<UIState> = _uiState

    init {
        setUIState(UIState.Workout())
    }

    private fun setUIState(state: UIState) {
        viewModelScope.launch {
            when (state) {
                is UIState.Workout ->
                    _uiState.value = state.copy(onClick = {
                        println("ITS RUNNING")
                        setUIState(UIState.Athlete())
                    })

                is UIState.Athlete ->
                    _uiState.value = state.copy(onClick = {
                        println("ITS RUNNING")
                        setUIState(UIState.Workout())
                    })
            }
        }
    }
}