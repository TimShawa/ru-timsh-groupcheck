package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.XStatusMissed: ImageVector
    get() {
        if (_XStatusMissed != null) {
            return _XStatusMissed!!
        }
        _XStatusMissed = ImageVector.Builder(
            name = "Rounded.XStatusMissed",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveToRelative(480f, 522.15f)
                lineToRelative(122.92f, 122.93f)
                quadToRelative(8.31f, 8.3f, 20.89f, 8.5f)
                quadToRelative(12.57f, 0.19f, 21.27f, -8.5f)
                quadToRelative(8.69f, -8.7f, 8.69f, -21.08f)
                quadToRelative(0f, -12.38f, -8.69f, -21.08f)
                lineTo(522.15f, 480f)
                lineToRelative(122.93f, -122.92f)
                quadToRelative(8.3f, -8.31f, 8.5f, -20.89f)
                quadToRelative(0.19f, -12.57f, -8.5f, -21.27f)
                quadToRelative(-8.7f, -8.69f, -21.08f, -8.69f)
                quadToRelative(-12.38f, 0f, -21.08f, 8.69f)
                lineTo(480f, 437.85f)
                lineTo(357.08f, 314.92f)
                quadToRelative(-8.31f, -8.3f, -20.89f, -8.5f)
                quadToRelative(-12.57f, -0.19f, -21.27f, 8.5f)
                quadToRelative(-8.69f, 8.7f, -8.69f, 21.08f)
                quadToRelative(0f, 12.38f, 8.69f, 21.08f)
                lineTo(437.85f, 480f)
                lineTo(314.92f, 602.92f)
                quadToRelative(-8.3f, 8.31f, -8.5f, 20.89f)
                quadToRelative(-0.19f, 12.57f, 8.5f, 21.27f)
                quadToRelative(8.7f, 8.69f, 21.08f, 8.69f)
                quadToRelative(12.38f, 0f, 21.08f, -8.69f)
                lineTo(480f, 522.15f)
                close()
                moveTo(480.07f, 860f)
                quadToRelative(-78.84f, 0f, -148.21f, -29.92f)
                reflectiveQuadToRelative(-120.68f, -81.21f)
                quadToRelative(-51.31f, -51.29f, -81.25f, -120.63f)
                quadTo(100f, 558.9f, 100f, 480.07f)
                quadToRelative(0f, -78.84f, 29.92f, -148.21f)
                reflectiveQuadToRelative(81.21f, -120.68f)
                quadToRelative(51.29f, -51.31f, 120.63f, -81.25f)
                quadTo(401.1f, 100f, 479.93f, 100f)
                quadToRelative(78.84f, 0f, 148.21f, 29.92f)
                reflectiveQuadToRelative(120.68f, 81.21f)
                quadToRelative(51.31f, 51.29f, 81.25f, 120.63f)
                quadTo(860f, 401.1f, 860f, 479.93f)
                quadToRelative(0f, 78.84f, -29.92f, 148.21f)
                reflectiveQuadToRelative(-81.21f, 120.68f)
                quadToRelative(-51.29f, 51.31f, -120.63f, 81.25f)
                quadTo(558.9f, 860f, 480.07f, 860f)
                close()
            }
        }.build()

        return _XStatusMissed!!
    }

@Suppress("ObjectPropertyName")
private var _XStatusMissed: ImageVector? = null
