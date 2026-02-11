package org.crabcraft.trackmaster.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.ui.common.components.Card
import org.crabcraft.trackmaster.ui.common.components.NavigationBar
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = TrackMasterDatabase.getDatabase(applicationContext)

        // ViewModel Factory
        val viewModel: MainViewModel by viewModels {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel(db) as T
                }
            }
        }

        setContent {
            TrackMasterTheme {

                val uiState by viewModel.uiState.collectAsState()
                val athletes by viewModel.athletes.collectAsState()
                val workouts by viewModel.workouts.collectAsState()

                val athleteMode = intent.getBooleanExtra("athleteMode", false)
                if (athleteMode)
                    viewModel.setUIState(UIState.Athlete)

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
                                workouts.forEach { workout -> Card(trackable = workout, onClick = { viewModel.removeTrackable(workout) }) }
                            is UIState.Athlete ->
                                athletes.forEach { athlete -> Card(trackable = athlete, onClick = { navigateToAthlete(athlete) }) }
                        }
                    }
                }
            }
        }
    }

    fun navigateToAthlete(athlete: Athlete) {
        val intent = Intent(this@MainActivity, AthleteActivity::class.java).apply {
            putExtra("id", athlete.uid)
        }
        startActivity(intent)
    }
}
