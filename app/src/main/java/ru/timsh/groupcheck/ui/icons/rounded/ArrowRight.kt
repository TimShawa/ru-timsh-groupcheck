package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.ArrowRight: ImageVector
    get() {
        if (_ArrowRight != null) {
            return _ArrowRight!!
        }
        _ArrowRight = ImageVector.Builder(
            name = "Rounded.ArrowRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(428.2f, 630.84f)
                quadToRelative(-7.35f, 0f, -12.78f, -4.97f)
                quadToRelative(-5.42f, -4.97f, -5.42f, -13.1f)
                verticalLineToRelative(-265.54f)
                quadToRelative(0f, -8.13f, 5.48f, -13.1f)
                quadToRelative(5.47f, -4.97f, 12.77f, -4.97f)
                quadToRelative(1.83f, 0f, 12.67f, 5.61f)
                lineToRelative(126.04f, 126.04f)
                quadToRelative(4.35f, 4.34f, 6.35f, 8.98f)
                quadToRelative(2f, 4.64f, 2f, 10.21f)
                quadToRelative(0f, 5.57f, -2f, 10.21f)
                quadToRelative(-2f, 4.64f, -6.35f, 8.98f)
                lineTo(440.92f, 625.24f)
                quadToRelative(-2.61f, 2.6f, -5.83f, 4.1f)
                quadToRelative(-3.21f, 1.5f, -6.89f, 1.5f)
                close()
            }
        }.build()

        return _ArrowRight!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowRight: ImageVector? = null
