package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.TrackMasterApplication
import org.crabcraft.trackmaster.data.repository.AthleteRepository
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout
import org.crabcraft.trackmaster.util.Item
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.AthleteViewModel
import org.crabcraft.trackmaster.viewmodel.MainViewModel
import org.crabcraft.trackmaster.viewmodel.WorkoutViewModel

@Composable
fun ExpandableList(expanded: Boolean = false, name: String, onClick: () -> Unit = {}, list: MutableList<Item> = mutableListOf()) {
    when (expanded) {
        true -> {
            ExpandedList(name, onClick)
        }
        false -> {
            CollapsedList(name, onClick)
        }
    }
}

@Composable
private fun CollapsedList(name: String, onClick: () -> Unit) {
    Row (
        Modifier
            .clickable(onClick = onClick)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
            imageVector = ImageVector.vectorResource(R.drawable.caret_down),
            contentDescription = null
        )
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.fillMaxWidth().height(48.dp).wrapContentHeight(Alignment.CenterVertically)
        )
    }

}

@Composable
private fun ExpandedList(name: String, onClick: () -> Unit) {
    val application = LocalContext.current.applicationContext as TrackMasterApplication
    val athletes: List<Athlete> by application.container.athleteViewModel.allAthletes.collectAsState(initial = emptyList())
    val workouts: List<Workout> by application.container.workoutViewModel.allWorkouts.collectAsState(initial = emptyList())
    val mainViewModel = MainViewModel()
    val uiState: UIState by mainViewModel.uiState.observeAsState(UIState.Workout())

    Column (
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 1f)),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Row (
            Modifier.clickable(onClick = onClick)
        ) {
            Image(
                modifier = Modifier.size(48.dp).rotate(180f),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                imageVector = ImageVector.vectorResource(R.drawable.caret_down),
                contentDescription = null
            )
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.fillMaxWidth().height(48.dp).wrapContentHeight(Alignment.CenterVertically)
            )
        }
        if (uiState is UIState.Workout) {
            athletes.forEach { athlete -> Item(athlete) }
        } else {
            workouts.forEach { workout -> Item(workout) }
        }
    }
}