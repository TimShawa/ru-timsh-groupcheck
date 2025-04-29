package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.KeyboardArrowUp: ImageVector
    get() {
        if (_KeyboardArrowUp != null) {
            return _KeyboardArrowUp!!
        }
        _KeyboardArrowUp = ImageVector.Builder(
            name = "Rounded.KeyboardArrowUp",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(480f, 418.15f)
                lineTo(317.08f, 581.08f)
                quadToRelative(-8.31f, 8.3f, -20.89f, 8.5f)
                quadToRelative(-12.57f, 0.19f, -21.27f, -8.5f)
                quadToRelative(-8.69f, -8.7f, -8.69f, -21.08f)
                quadToRelative(0f, -12.38f, 8.69f, -21.08f)
                lineToRelative(179.77f, -179.77f)
                quadToRelative(10.85f, -10.84f, 25.31f, -10.84f)
                quadToRelative(14.46f, 0f, 25.31f, 10.84f)
                lineToRelative(179.77f, 179.77f)
                quadToRelative(8.3f, 8.31f, 8.5f, 20.89f)
                quadToRelative(0.19f, 12.57f, -8.5f, 21.27f)
                quadToRelative(-8.7f, 8.69f, -21.08f, 8.69f)
                quadToRelative(-12.38f, 0f, -21.08f, -8.69f)
                lineTo(480f, 418.15f)
                close()
            }
        }.build()

        return _KeyboardArrowUp!!
    }

@Suppress("ObjectPropertyName")
private var _KeyboardArrowUp: ImageVector? = null
