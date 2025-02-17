package org.crabcraft.trackmaster.ui.workout_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import org.crabcraft.trackmaster.ui.common.shared_components.NavigationBar
import org.crabcraft.trackmaster.ui.common.shared_components.StatusBar
import org.crabcraft.trackmaster.ui.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackMasterTheme {
                val viewModel = MainViewModel()
                val uiState: UIState by viewModel.uiState.observeAsState(UIState.Workout())
                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = { StatusBar(uiState) },
                    bottomBar = { NavigationBar(uiState) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(it)
                    ) {
                    }
                }
            }
        }
    }
}
