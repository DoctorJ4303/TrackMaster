package org.crabcraft.trackmaster.util

import org.crabcraft.trackmaster.R

sealed class UIState (val title: String, val icon: Int) {
    object Workout : UIState("Workouts", R.drawable.workout)
    object Athlete : UIState("Athletes", R.drawable.athlete)
}
