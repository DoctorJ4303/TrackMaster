package org.crabcraft.trackmaster.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Blue60,
    secondary = Blue80,
    background = Blue40,
    surface = Blue60,
    onPrimary = Tan,
    onSecondary = Tan,
    onSurface = Tan
)

private val LightColorScheme = lightColorScheme(
    primary = Tan,
    secondary = Orange,
    background = White,
    surface = Orange,
    onPrimary = Blue40,
    onSecondary = Blue40,
    onSurface = Blue40
)

@Composable
fun TrackMasterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}