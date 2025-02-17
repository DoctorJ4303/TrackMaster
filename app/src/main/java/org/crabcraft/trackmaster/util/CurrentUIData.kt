package org.crabcraft.trackmaster.util

import android.view.View
import android.view.View.OnClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.navigation.NavigationItem

sealed class CurrentUIState {
    data class Workout(
        val title: String = "Workouts",
        val icon: Int = R.drawable.workout,
        val onClick: () -> Unit,
        val icons: NavigationItem = NavigationItem(
            selectedIcon = {
                Icon(
                    selected = true,
                    icon = R.drawable.workout,
                    onClick = {}
                )
            },
            unselectedIcon = {
                Icon(
                    selected = false,
                    icon = R.drawable.athlete,
                    onClick = onClick
                )
            }
        )
    ): CurrentUIState()
    data class Athlete(
        val title: String = "Athletes",
        val icon: Int = R.drawable.athlete,
        val onClick: () -> Unit,
        val icons: NavigationItem = NavigationItem(
            selectedIcon = {
                Icon(
                    selected = true,
                    icon = R.drawable.athlete
                )
            },
            unselectedIcon = {
                Icon(
                    selected = false,
                    icon = R.drawable.workout,
                    onClick = onClick
                )
            }
        )
    ): CurrentUIState()
}

@Composable
private fun Icon(selected: Boolean, icon: Int, onClick: () -> Unit) {
    Surface (
        modifier = Modifier.size(56.dp),
        shape = RoundedCornerShape(20.dp),
        color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
        onClick = onClick
    ) {
        Image(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier.size(36.dp).padding(6.dp)
        )
    }
}