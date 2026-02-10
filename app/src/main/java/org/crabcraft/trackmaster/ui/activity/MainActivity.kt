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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.ui.common.components.NavigationBar
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TrackMasterTheme {

                val viewModel = MainViewModel()

                val uiState by viewModel.uiState.collectAsState()
                //val expandableItems: MutableList<ExpandableItem> by viewModel.expandableItems.observeAsState(mutableListOf())

                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = { StatusBar(uiState) },
                    bottomBar = { NavigationBar(viewModel) }
                ) { it
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(top = 92.dp, start = 16.dp, end = 16.dp, bottom = 92.dp)

                    ) {
                        //expandableItems.forEach { item -> item.getListItem() }
                        //expandableItems.forEach { item -> println(item.expanded) }
                    }
                }
            }
        }
    }
}
