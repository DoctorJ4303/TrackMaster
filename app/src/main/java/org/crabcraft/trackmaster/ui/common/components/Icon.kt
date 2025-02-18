package org.crabcraft.trackmaster.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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

@Composable
fun Icon(selected: Boolean, icon: Int, onClick: () -> Unit) {
    Surface (
        modifier = if (!selected) Modifier.size(56.dp).clickable(onClick = onClick) else Modifier.size(56.dp),
        shape = RoundedCornerShape(20.dp),
        color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
    ) {
        Image(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier
                .size(36.dp)
                .padding(6.dp)
        )
    }
}