package org.crabcraft.trackmaster.util

import androidx.compose.runtime.Composable

sealed class ExpandableItem() {
    abstract val title: String
    abstract var expanded: Boolean
    abstract val onClick: () -> Unit

    data class Workout(
        override val title: String,
        override var expanded: Boolean = false,
        override val onClick: () -> Unit,
        var workouts: List<Workout> = listOf()) : ExpandableItem()

    data class Athlete(
        override val title: String,
        override var expanded: Boolean = false,
        override val onClick: () -> Unit,
        var athletes: List<Athlete> = listOf()) : ExpandableItem()
}