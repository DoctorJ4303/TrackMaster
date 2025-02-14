package org.crabcraft.trackmaster.ui.common.shared_components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun NavBar () {
    androidx.compose.material3.NavigationBar (
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onBackground,
        tonalElevation = 0.dp
    )
    {

    }
}