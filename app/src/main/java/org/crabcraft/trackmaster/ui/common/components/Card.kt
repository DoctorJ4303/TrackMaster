package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable

@Composable
fun Card (trackable: Trackable, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
        ) {
            Image(
                imageVector = ImageVector.vectorResource(if (trackable is Athlete) R.drawable.athlete else R.drawable.workout),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.padding(start = 10.dp))
            Text(
                trackable.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}