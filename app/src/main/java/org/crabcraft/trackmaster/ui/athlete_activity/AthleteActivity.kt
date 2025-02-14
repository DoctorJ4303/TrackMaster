package org.crabcraft.trackmaster.ui.athlete_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import org.crabcraft.trackmaster.ui.common.shared_components.NavBar
import org.crabcraft.trackmaster.ui.common.shared_components.StatusBar
import org.crabcraft.trackmaster.ui.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.Selected

class AthleteActivity : ComponentActivity() {

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
}