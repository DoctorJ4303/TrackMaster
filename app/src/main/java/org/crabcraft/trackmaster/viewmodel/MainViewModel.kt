package org.crabcraft.trackmaster.viewmodel

import androidx.compose.animation.core.copy
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.ui.common.components.ListItem
import org.crabcraft.trackmaster.util.UIState

class MainViewModel :ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Workout())
    private val _listItems = MutableLiveData<MutableList<ListItem>>(mutableListOf())

    val uiState: LiveData<UIState> = _uiState
    val listItems: LiveData<MutableList<ListItem>> = _listItems

    init {
        setUIState(UIState.Workout())
    }

    private fun setUIState(state: UIState) {
        viewModelScope.launch {
            when (state) {
                is UIState.Workout -> {
                    _uiState.value = state.copy(onClick = {
                        println("ITS RUNNING")
                        setUIState(UIState.Athlete())
                    })

                    _listItems.value = mutableListOf(
                        ListItem.Workouts("Favorites", onClick = {
                            setListItemSelected(0)
                        }),
                        ListItem.Workouts("Recents", onClick = {
                            setListItemSelected(1)
                        }),
                        ListItem.Workouts("All", onClick = {
                            setListItemSelected(2)
                        })
                    )
                }

                is UIState.Athlete -> {
                    _uiState.value = state.copy(onClick = {
                        setUIState(UIState.Workout())
                    })

                    _listItems.value = mutableListOf(
                        ListItem.Athlete("Favorites", onClick = {
                            setListItemSelected(0)
                        }),
                        ListItem.Athlete("Recents", onClick = {
                            setListItemSelected(1)
                        }),
                        ListItem.Athlete("All", onClick = {
                            setListItemSelected(2)
                        })
                    )
                }
            }
        }
    }

    private fun setListItemSelected(index: Int) {
        viewModelScope.launch {
            println("ITS RUNNING")
            val currentList = _listItems.value?.toMutableList() ?: return@launch
            val newList = currentList.mapIndexed { i, item ->
                if (i == index) {
                    // Toggle the clicked item's expanded state
                    item.copy(expanded = !item.expanded)
                } else {
                    // Collapse all other items
                    item.copy(expanded = false)
                }
            }
            _listItems.value = newList.toMutableList()
        }
    }
}