package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.util.ExpandableItem
import org.crabcraft.trackmaster.util.UIState

class MainViewModel: ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Workout())
    private val _expandableItems = MutableLiveData<MutableList<ExpandableItem>>(mutableListOf())

    val uiState: LiveData<UIState> = _uiState
    val expandableItems: LiveData<MutableList<ExpandableItem>> = _expandableItems

    init {
        setUIState(UIState.Workout())
    }

    private fun setUIState(state: UIState) {
        viewModelScope.launch {
            when (state) {
                is UIState.Workout -> {
                    _uiState.value = state.copy(onClick = {
                        setUIState(UIState.Athlete())
                    })

                    _expandableItems.value = mutableListOf(
                        ExpandableItem.Workout("Favorites", onClick = {
                            setListItemSelected(0)
                        }),
                        ExpandableItem.Workout("Recents", onClick = {
                            setListItemSelected(1)
                        }),
                        ExpandableItem.Workout("All", onClick = {
                            setListItemSelected(2)
                        })
                    )
                }

                is UIState.Athlete -> {
                    _uiState.value = state.copy(onClick = {
                        setUIState(UIState.Workout())
                    })

                    _expandableItems.value = mutableListOf(
                        ExpandableItem.Athlete("Favorites", onClick = {
                            setListItemSelected(0)
                        }),
                        ExpandableItem.Athlete("Recents", onClick = {
                            setListItemSelected(1)
                        }),
                        ExpandableItem.Athlete("All", onClick = {
                            setListItemSelected(2)
                        })
                    )
                }
            }
        }
    }

    private fun setListItemSelected(index: Int) {
        viewModelScope.launch {
            val currentList = _expandableItems.value!!.toMutableList()

            List(currentList.size) { i ->
                val item: ExpandableItem
                if (_uiState.value is UIState.Workout) {
                    item = (currentList[i] as ExpandableItem.Workout)
                    currentList[i] = item.copy(expanded = i == index && !item.expanded)

                }
                else if (_uiState.value is UIState.Athlete) {
                    item = (currentList[i] as ExpandableItem.Athlete)
                    currentList[i] = item.copy(expanded = i == index && !item.expanded)
                }
            }
            _expandableItems.value = currentList
        }
    }
}