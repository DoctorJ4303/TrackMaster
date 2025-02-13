package org.crabcraft.trackmaster.ui.common.shared_components

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import org.crabcraft.trackmaster.R
import org.crabcraft.trackmaster.ui.theme.Tan

@Composable
fun StatusBar(title: String) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    Surface (
        modifier = Modifier.fillMaxWidth().height(72.dp),
        shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row (
            modifier = Modifier.padding(12.dp),
        )
        {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.sneaker_move_bold, imageLoader),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.weight(1f))
            Text(
                title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxHeight().wrapContentHeight(align = Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(R.drawable.search, imageLoader),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}
