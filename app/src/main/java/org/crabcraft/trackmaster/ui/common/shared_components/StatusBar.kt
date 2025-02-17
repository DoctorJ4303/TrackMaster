package org.crabcraft.trackmaster.ui.common.shared_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dropShadow
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.ui.workout_activity.MainActivity
import org.crabcraft.trackmaster.viewmodel.MainViewModel

@Composable
fun StatusBar (viewModel: MainViewModel) {

    val shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
    Surface(
        modifier = Modifier.fillMaxWidth().height(72.dp).dropShadow(shape),
        shape = shape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
        ) {
            Image(
                imageVector = ImageVector.vectorResource(viewModel.getIconState()),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.weight(1f))
            Text(
                viewModel.getTitleState(),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(Modifier.weight(1f))
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.search),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(48.dp)
            )
        }
    }
}
