package org.crabcraft.trackmaster.ui

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class NavigationBarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height
        val curveHeight = 36.dp.toPx(density)

        return Outline.Generic(
            path = Path().apply {
                reset()
                lineTo(0f, 0f)
                lineTo(width / 2 - curveHeight, 0f)
                arcTo(
                    rect = Rect(
                        left = width / 2 - curveHeight,
                        top = -curveHeight,
                        right = width / 2 + curveHeight,
                        bottom = curveHeight
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                lineTo(width, 0f)
                lineTo(width, height)
                lineTo(0f, height)
                close()
            }
        )
    }
}

fun Dp.toPx(density: Density) = with(density) { toPx() }