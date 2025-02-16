package org.crabcraft.trackmaster.ui.workout_activity

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.crabcraft.trackmaster.ui.common.shared_components.NavBar
import org.crabcraft.trackmaster.ui.common.shared_components.StatusBar
import org.crabcraft.trackmaster.ui.theme.*
import org.crabcraft.trackmaster.util.Selected

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackMasterTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = {
                        StatusBar()
                    },
                    bottomBar = {
                        NavBar()
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

    object TrackMasterApplication: Application() {
        val selected = mutableStateOf(Selected.WORKOUT)
    }
}
