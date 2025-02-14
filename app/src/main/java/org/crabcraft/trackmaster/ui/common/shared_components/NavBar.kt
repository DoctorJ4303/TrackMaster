package org.crabcraft.trackmaster.ui.common.shared_components

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import dropShadow
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.ui.workout_activity.WorkoutActivity
import org.crabcraft.trackmaster.ui.athlete_activity.AthleteActivity

@Composable
fun NavBar (component: ComponentActivity) {

    val shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    val workoutTint = when {
        (component is WorkoutActivity) -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onPrimary
    }
    val athleteTint = when {
        (component is WorkoutActivity) -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.colorScheme.primary
    }

    Surface(
        modifier = Modifier.fillMaxWidth().height(72.dp).dropShadow(shape, offsetY = (-4).dp),
        shape = shape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        ) {
            Spacer(Modifier.weight(1f))
            Surface (
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(20.dp),
                color = athleteTint,
                onClick = {
                    if (component is AthleteActivity) {
                        component.startActivity(Intent(component, WorkoutActivity::class.java))
                    }
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.workout),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(workoutTint),
                    modifier = Modifier.size(36.dp).padding(6.dp)
                )
            }
            Spacer(Modifier.weight(4f))
            Surface (
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(20.dp),
                color = workoutTint,
                onClick = {
                    if (component is WorkoutActivity) {
                        component.startActivity(Intent(component, AthleteActivity::class.java))
                    }
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.athlete),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(athleteTint),
                    modifier = Modifier.size(36.dp).padding(6.dp)
                )
            }
            Spacer(Modifier.weight(1f))
        }

    }
}