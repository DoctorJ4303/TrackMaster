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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.ui.common.components.ListItem
import org.crabcraft.trackmaster.ui.common.components.NavigationBar
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.ListItem
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackMasterTheme {

                val viewModel = MainViewModel()

                val uiState: UIState by viewModel.uiState.observeAsState(UIState.Workout())
                val listItems: MutableList<ListItem> by viewModel.listItems.observeAsState(mutableListOf())

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
                        listItems.forEach { item -> item.getListItem()() }
                        listItems.forEach {item -> println(item.expanded)}
                    }
                }
            }
        }
    }
}
