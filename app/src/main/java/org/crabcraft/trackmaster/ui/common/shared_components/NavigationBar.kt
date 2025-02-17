package org.crabcraft.trackmaster.ui.common.shared_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dropShadow
import org.crabcraft.trackmaster.util.CurrentUIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

@Composable
fun NavigationBar (uiState: CurrentUIState) {

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
            uiState.workoutIcon()
            Spacer(Modifier.weight(4f))
            uiState.athleteIcon()
            Spacer(Modifier.weight(1f))
        }
    }
}