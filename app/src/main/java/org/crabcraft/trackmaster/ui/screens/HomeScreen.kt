package org.crabcraft.trackmaster.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.model.TrackableType
import org.crabcraft.trackmaster.ui.common.components.Card
import org.crabcraft.trackmaster.ui.common.components.NavigationBar
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

@Serializable
object HomeScreen

@Composable
fun HomeScreenComposable(viewModel: MainViewModel, onNavigateToDetail: (trackable: Trackable, type: TrackableType) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    val athletes by viewModel.athletes.collectAsState()
    val workouts by viewModel.workouts.collectAsState()

    Scaffold (
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        topBar = { StatusBar(viewModel) },
        bottomBar = { NavigationBar(viewModel) }
    ) { it
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 92.dp, start = 16.dp, end = 16.dp, bottom = 92.dp)

        ) {
            when (uiState) {
                is UIState.Workout ->
                    workouts.forEach { workout -> Card(trackable = workout, onClick = { onNavigateToDetail(workout, TrackableType.WORKOUT) }) }
                is UIState.Athlete ->
                    athletes.forEach { athlete -> Card(trackable = athlete, onClick = { onNavigateToDetail(athlete, TrackableType.ATHLETE) }) }
            }
        }
    }
}