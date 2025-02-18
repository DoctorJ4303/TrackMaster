package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.model.Workout

sealed class ListItem() {
    abstract val title: String
    abstract var expanded: Boolean
    abstract val onClick: () -> Unit

    data class Workouts(
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

@Composable
fun ListItem(expanded: Boolean = false, name: String, onClick: () -> Unit = {}) {
    when (expanded) {
        true -> {
            Box(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 1f))
                    .clickable(onClick = onClick)
            ) {
                Row {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.caret_down),
                        contentDescription = null
                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.fillMaxSize().wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
        }
        false -> {
            Box(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.75f))
                    .clickable(onClick = onClick)
            ) {
                Row {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.caret_down),
                        contentDescription = null
                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.fillMaxSize().wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}