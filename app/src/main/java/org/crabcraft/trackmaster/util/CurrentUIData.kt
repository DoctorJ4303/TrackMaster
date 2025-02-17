package org.crabcraft.trackmaster.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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

sealed class CurrentUIState () {
    data class Workout(
        override val title: String = "Workouts",
        override val icon: Int = R.drawable.workout,
        val onClick: () -> Unit = {},
        override var workoutIcon: @Composable () -> Unit = {},
        override var athleteIcon: @Composable () -> Unit = {},
    ): CurrentUIState() {
        init {
            athleteIcon = {
                Icon(
                    selected = false,
                    icon = R.drawable.athlete,
                    onClick = this.onClick
                )
            }
            workoutIcon = {
                Icon(
                    selected = true,
                    icon = R.drawable.workout,
                    onClick = {}
                )
            }
        }
    }

    data class Athlete(
        override val title: String = "Athletes",
        override val icon: Int = R.drawable.athlete,
        val onClick: () -> Unit = {},
        override var workoutIcon: @Composable () -> Unit = {},
        override var athleteIcon: @Composable () -> Unit = {},
    ): CurrentUIState() {
        init {
            athleteIcon = {
                Icon(
                    selected = true,
                    icon = R.drawable.athlete,
                    onClick = {}
                )
            }
            workoutIcon = {
                Icon(
                    selected = false,
                    icon = R.drawable.workout,
                    onClick = this.onClick
                )
            }
        }
    }
    open val title: String = ""
    open val icon: Int = 0
    open var workoutIcon: @Composable () -> Unit = {}
    open var athleteIcon: @Composable () -> Unit = {}
}

@Composable
private fun Icon(selected: Boolean, icon: Int, onClick: () -> Unit) {
    Surface (
        modifier = Modifier.size(56.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
    ) {
        Image(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier
                .size(36.dp)
                .padding(6.dp)
        )
    }
}