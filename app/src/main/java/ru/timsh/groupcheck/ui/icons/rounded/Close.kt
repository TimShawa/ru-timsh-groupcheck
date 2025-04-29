package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Close: ImageVector
    get() {
        if (_Close != null) {
            return _Close!!
        }
        _Close = ImageVector.Builder(
            name = "Rounded.Close",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(480f, 522.15f)
                lineTo(277.08f, 725.08f)
                quadToRelative(-8.31f, 8.3f, -20.89f, 8.5f)
                quadToRelative(-12.57f, 0.19f, -21.27f, -8.5f)
                quadToRelative(-8.69f, -8.7f, -8.69f, -21.08f)
                quadToRelative(0f, -12.38f, 8.69f, -21.08f)
                lineTo(437.85f, 480f)
                lineTo(234.92f, 277.08f)
                quadToRelative(-8.3f, -8.31f, -8.5f, -20.89f)
                quadToRelative(-0.19f, -12.57f, 8.5f, -21.27f)
                quadToRelative(8.7f, -8.69f, 21.08f, -8.69f)
                quadToRelative(12.38f, 0f, 21.08f, 8.69f)
                lineTo(480f, 437.85f)
                lineToRelative(202.92f, -202.93f)
                quadToRelative(8.31f, -8.3f, 20.89f, -8.5f)
                quadToRelative(12.57f, -0.19f, 21.27f, 8.5f)
                quadToRelative(8.69f, 8.7f, 8.69f, 21.08f)
                quadToRelative(0f, 12.38f, -8.69f, 21.08f)
                lineTo(522.15f, 480f)
                lineToRelative(202.93f, 202.92f)
                quadToRelative(8.3f, 8.31f, 8.5f, 20.89f)
                quadToRelative(0.19f, 12.57f, -8.5f, 21.27f)
                quadToRelative(-8.7f, 8.69f, -21.08f, 8.69f)
                quadToRelative(-12.38f, 0f, -21.08f, -8.69f)
                lineTo(480f, 522.15f)
                close()
            }
        }.build()

        return _Close!!
    }

@Suppress("ObjectPropertyName")
private var _Close: ImageVector? = null
