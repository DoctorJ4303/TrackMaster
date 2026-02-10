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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.TrackMasterApplication
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Workout
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

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
    val viewModel = MainViewModel()
    val uiState by viewModel.uiState.collectAsState()

    ExpandedListContent(
        name = name,
        onClick = onClick,
        athletes = athletes,
        workouts = workouts,
        uiState = uiState
    )
}

@Composable
fun ExpandedListContent(
    name: String,
    onClick: () -> Unit,
    athletes: List<Athlete>,
    workouts: List<Workout>,
    uiState: UIState
) {
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

@Preview(showBackground = true)
@Composable
fun ExpandableListExpandedPreview() {
    TrackMasterTheme {
        Box(Modifier.padding(16.dp)) {
            ExpandedListContent(
                name = "Athletes",
                onClick = {},
                athletes = listOf(
                    Athlete(1, "John Doe", "100m: 10.5s"),
                    Athlete(2, "Jane Smith", "200m: 22.1s")
                ),
                workouts = emptyList(),
                uiState = UIState.Workout
            )
        }
    }
}