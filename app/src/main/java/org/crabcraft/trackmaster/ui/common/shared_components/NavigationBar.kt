package org.crabcraft.trackmaster.ui.common.shared_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dropShadow
import org.crabcraft.trackmaster.ui.NavigationBarShape
import org.crabcraft.trackmaster.util.UIState

@Composable
fun NavigationBar (uiState: UIState) {

    val shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)

    Box(
        modifier = Modifier.fillMaxWidth().height(72.dp)
    ) {
        Surface(
            modifier = Modifier.align(Alignment.BottomCenter)
                .dropShadow(shape = NavigationBarShape(), offsetY = (-4).dp),
            shape = shape,
            color = MaterialTheme.colorScheme.primary
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
            ) {
                Spacer(Modifier.weight(1f))
                uiState.workoutIcon()
                Spacer(Modifier.weight(4f))
                uiState.athleteIcon()
                Spacer(Modifier.weight(1f))
            }
        }
        FloatingCircleButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomCenter).size(72.dp).offset(y = (-36).dp)
        )
    }
}