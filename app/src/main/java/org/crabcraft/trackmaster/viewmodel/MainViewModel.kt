package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.crabcraft.trackmaster.util.ListItem
import org.crabcraft.trackmaster.util.UIState

class MainViewModel: ViewModel() {
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
                        setUIState(UIState.Athlete())
                    })

                    _listItems.value = mutableListOf(
                        ListItem.Workout("Favorites", onClick = {
                            setListItemSelected(0)
                        }),
                        ListItem.Workout("Recents", onClick = {
                            setListItemSelected(1)
                        }),
                        ListItem.Workout("All", onClick = {
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
            val currentList = _listItems.value!!.toMutableList()

            List(currentList.size) { i ->
                val item: ListItem
                if (_uiState.value is UIState.Workout) {
                    item = (currentList[i] as ListItem.Workout)
                    currentList[i] = item.copy(expanded = i == index && !item.expanded)

                }
                else if (_uiState.value is UIState.Athlete) {
                    item = (currentList[i] as ListItem.Athlete)
                    currentList[i] = item.copy(expanded = i == index && !item.expanded)
                }
            }
            _listItems.value = currentList
        }
    }
}