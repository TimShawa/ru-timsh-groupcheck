package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.StatusLate: ImageVector
    get() {
        if (_StatusLate != null) {
            return _StatusLate!!
        }
        _StatusLate = ImageVector.Builder(
            name = "Rounded.StatusLate",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(510f, 467.85f)
                lineTo(510f, 310f)
                quadToRelative(0f, -12.75f, -8.63f, -21.38f)
                quadToRelative(-8.63f, -8.62f, -21.38f, -8.62f)
                quadToRelative(-12.76f, 0f, -21.37f, 8.62f)
                quadTo(450f, 297.25f, 450f, 310f)
                verticalLineToRelative(167.08f)
                quadToRelative(0f, 7.06f, 2.62f, 13.68f)
                quadToRelative(2.61f, 6.62f, 8.23f, 12.24f)
                lineToRelative(137f, 137f)
                quadToRelative(8.3f, 8.31f, 20.88f, 8.5f)
                quadToRelative(12.58f, 0.19f, 21.27f, -8.5f)
                reflectiveQuadToRelative(8.69f, -21.08f)
                quadToRelative(0f, -12.38f, -8.69f, -21.07f)
                lineToRelative(-130f, -130f)
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
                moveTo(480f, 480f)
                close()
                moveTo(480f, 800f)
                quadToRelative(133f, 0f, 226.5f, -93.5f)
                reflectiveQuadTo(800f, 480f)
                quadToRelative(0f, -133f, -93.5f, -226.5f)
                reflectiveQuadTo(480f, 160f)
                quadToRelative(-133f, 0f, -226.5f, 93.5f)
                reflectiveQuadTo(160f, 480f)
                quadToRelative(0f, 133f, 93.5f, 226.5f)
                reflectiveQuadTo(480f, 800f)
                close()
            }
        }.build()

        return _StatusLate!!
    }

@Suppress("ObjectPropertyName")
private var _StatusLate: ImageVector? = null
