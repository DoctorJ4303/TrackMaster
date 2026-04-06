package org.crabcraft.trackmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.viewmodel.MainViewModel

@Composable
fun AthleteScreenComposable(viewModel: MainViewModel, athlete: Athlete) {
    val athletes = viewModel.athletes.collectAsState()
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = athlete.name)
    }
}