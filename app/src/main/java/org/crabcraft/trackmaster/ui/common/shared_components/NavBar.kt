package org.crabcraft.trackmaster.ui.common.shared_components

import android.content.Intent
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dropShadow
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.ui.workout_activity.MainActivity
import org.crabcraft.trackmaster.util.Selected

@Composable
fun NavBar () {
    val selected = remember { MainActivity.TrackMasterApplication.selected }

    val shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)

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
                color = if(selected.value==Selected.WORKOUT) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
                onClick = {
                    MainActivity.TrackMasterApplication.selected.value = Selected.WORKOUT
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.workout),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if(selected.value==Selected.WORKOUT) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
                    modifier = Modifier.size(36.dp).padding(6.dp)
                )
            }
            Spacer(Modifier.weight(4f))
            Surface (
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(20.dp),
                color = if(selected.value==Selected.ATHLETE) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
                onClick = {
                    MainActivity.TrackMasterApplication.selected.value = Selected.ATHLETE
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.athlete),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if(selected.value==Selected.ATHLETE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
                    modifier = Modifier.size(36.dp).padding(6.dp)
                )
            }
            Spacer(Modifier.weight(1f))
        }

    }
}