package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.XSend: ImageVector
    get() {
        if (_XSend != null) {
            return _XSend!!
        }
        _XSend = ImageVector.Builder(
            name = "Rounded.XSend",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(190.66f, 748.91f)
                quadToRelative(-18.12f, 7.24f, -34.39f, -3.08f)
                reflectiveQuadTo(140f, 715.77f)
                verticalLineToRelative(-168.85f)
                lineTo(416.92f, 480f)
                lineTo(140f, 413.08f)
                verticalLineToRelative(-168.85f)
                quadToRelative(0f, -19.74f, 16.27f, -30.06f)
                reflectiveQuadToRelative(34.39f, -3.08f)
                lineToRelative(558.26f, 235.37f)
                quadToRelative(22.31f, 9.99f, 22.31f, 33.61f)
                quadToRelative(0f, 23.62f, -22.31f, 33.47f)
                lineTo(190.66f, 748.91f)
                close()
            }
        }.build()

        return _XSend!!
    }

@Suppress("ObjectPropertyName")
private var _XSend: ImageVector? = null
