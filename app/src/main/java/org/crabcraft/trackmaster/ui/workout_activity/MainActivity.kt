package org.crabcraft.trackmaster.ui.workout_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import org.crabcraft.trackmaster.ui.common.shared_components.NavigationBar
import org.crabcraft.trackmaster.ui.common.shared_components.StatusBar
import org.crabcraft.trackmaster.ui.theme.*
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackMasterTheme {
                val viewModel = MainViewModel()
                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = {
                        StatusBar(viewModel)
                    },
                    bottomBar = {
                        NavigationBar(viewModel)
                    }
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
