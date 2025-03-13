package org.crabcraft.trackmaster.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.TrackMasterApplication
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.ui.common.components.NavigationBar
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.ExpandableItem
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.DurationUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TrackMasterTheme {

                val viewModel = MainViewModel()

                val application = application as TrackMasterApplication
                val athleteViewModel = application.getAppContainer().athleteViewModel

                val uiState: UIState by viewModel.uiState.observeAsState(UIState.Workout())
                val expandableItems: MutableList<ExpandableItem> by viewModel.expandableItems.observeAsState(mutableListOf())

                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = { StatusBar(uiState) },
                    bottomBar = { NavigationBar(uiState) }
                ) { it
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(top = 92.dp, start = 16.dp, end = 16.dp, bottom = 92.dp)

                    ) {
                        expandableItems.forEach { item -> item.getListItem()() }
                        expandableItems.forEach { item -> println(item.expanded)}
                    }
                }
            }
        }
    }
}
