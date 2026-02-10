package org.crabcraft.trackmaster.util

import androidx.compose.runtime.Composable
import org.crabcraft.trackmaster.ui.common.components.Icon
import org.crabcraft.trackmaster.R

sealed class UIState (val title: String, val icon: Int) {
    object Workout : UIState("Workouts", R.drawable.workout)
    object Athlete : UIState("Athletes", R.drawable.athlete)
}
