package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.KeyboardArrowDown: ImageVector
    get() {
        if (_KeyboardArrowDown != null) {
            return _KeyboardArrowDown!!
        }
        _KeyboardArrowDown = ImageVector.Builder(
            name = "Rounded.KeyboardArrowDown",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(480f, 587.08f)
                quadToRelative(-7.23f, 0f, -13.46f, -2.31f)
                reflectiveQuadToRelative(-11.85f, -7.92f)
                lineTo(274.92f, 397.08f)
                quadToRelative(-8.3f, -8.31f, -8.5f, -20.89f)
                quadToRelative(-0.19f, -12.57f, 8.5f, -21.27f)
                quadToRelative(8.7f, -8.69f, 21.08f, -8.69f)
                quadToRelative(12.38f, 0f, 21.08f, 8.69f)
                lineTo(480f, 517.85f)
                lineToRelative(162.92f, -162.93f)
                quadToRelative(8.31f, -8.3f, 20.89f, -8.5f)
                quadToRelative(12.57f, -0.19f, 21.27f, 8.5f)
                quadToRelative(8.69f, 8.7f, 8.69f, 21.08f)
                quadToRelative(0f, 12.38f, -8.69f, 21.08f)
                lineTo(505.31f, 576.85f)
                quadToRelative(-5.62f, 5.61f, -11.85f, 7.92f)
                quadToRelative(-6.23f, 2.31f, -13.46f, 2.31f)
                close()
            }
        }.build()

        return _KeyboardArrowDown!!
    }

@Suppress("ObjectPropertyName")
private var _KeyboardArrowDown: ImageVector? = null
