package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.size.Size
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.model.Workout

@Composable
fun ListItem(expanded: Boolean = false, name: String, onClick: () -> Unit = {}) {
    when (expanded) {
        true -> {
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
                Column (
                    Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .wrapContentHeight(Alignment.Top)
                        .padding(top = 0.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Item()
                }
            }
        }
        false -> {
            Box(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
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
            }
        }
    }
}