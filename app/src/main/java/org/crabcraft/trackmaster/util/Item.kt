package org.crabcraft.trackmaster.util

sealed class Item {
    abstract val title: String
    abstract val onClick: () -> Unit
    data class Athlete(
        override val title: String,
        override val onClick: () -> Unit,
        val athlete: org.crabcraft.trackmaster.model.Athlete
    ): Item()
    data class Workout(
        override val title: String,
        override val onClick: () -> Unit,
        var workout: org.crabcraft.trackmaster.model.Workout
    ): Item()
}