package org.crabcraft.trackmaster.navigation

import androidx.compose.runtime.Composable

data class NavigationItem(
    val selectedIcon: @Composable () -> Unit,
    val unselectedIcon: @Composable () -> Unit
)