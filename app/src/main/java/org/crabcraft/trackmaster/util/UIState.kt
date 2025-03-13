package org.crabcraft.trackmaster.util

import androidx.compose.runtime.Composable
import org.crabcraft.trackmaster.ui.common.components.Icon
import org.crabcraft.trackmaster.R

sealed class UIState {
    data class Workout(
        override val title: String = "Workouts",
        override val icon: Int = R.drawable.workout,
        val onClick: () -> Unit = {},
        override var workoutIcon: @Composable () -> Unit = {},
        override var athleteIcon: @Composable () -> Unit = {},
    ): UIState() {
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
    ): UIState() {
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

    enum class State {
        Workout,
        Athlete
    }
}
