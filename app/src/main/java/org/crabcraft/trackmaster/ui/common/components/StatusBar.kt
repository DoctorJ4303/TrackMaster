package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dropShadow
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.util.UIState
import org.crabcraft.trackmaster.viewmodel.MainViewModel

@Composable
fun StatusBar (viewModel: MainViewModel) {
    val shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
    val uiState = viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxWidth().height(72.dp).dropShadow(shape),
        shape = shape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
        ) {
            Image(
                imageVector = ImageVector.vectorResource(uiState.value.icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.weight(1f))
            Text(
                uiState.value.title,
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

@Composable
fun StatusBar(trackable: Trackable, back: () -> Unit, delete: () -> Unit) {
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
                imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(48.dp).clickable { back() }
            )
            Text(
                trackable.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.size(48.dp).clickable { delete() }
            )
        }
    }
}