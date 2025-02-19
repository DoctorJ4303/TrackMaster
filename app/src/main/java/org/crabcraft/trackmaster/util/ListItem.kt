package org.crabcraft.trackmaster.util

import androidx.compose.runtime.Composable
import org.crabcraft.trackmaster.ui.common.components.ListItem

sealed class ListItem() {
    abstract val title: String
    abstract var expanded: Boolean
    abstract val onClick: () -> Unit

    data class Workout(
        override val title: String,
        override var expanded: Boolean = false,
        override val onClick: () -> Unit,
        var workouts: List<Workout> = listOf()) : ListItem()

    data class Athlete(
        override val title: String,
        override var expanded: Boolean = false,
        override val onClick: () -> Unit,
        var athletes: List<Athlete> = listOf()) : ListItem()

    fun getListItem(): @Composable () -> Unit {
        return {
            ListItem(name = this.title, expanded = this.expanded, onClick = onClick)
        }
    }
}