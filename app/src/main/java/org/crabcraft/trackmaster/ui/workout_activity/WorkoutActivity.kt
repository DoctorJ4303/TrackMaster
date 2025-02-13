package org.crabcraft.trackmaster.ui.workout_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.ui.common.shared_components.StatusBar
import org.crabcraft.trackmaster.ui.theme.*

class WorkoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackMasterTheme {
                Column (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
                ) {
                    StatusBar("Workouts")
                }
            }
        }
    }
}
