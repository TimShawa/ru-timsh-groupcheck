package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.ArrowBack: ImageVector
    get() {
        if (_ArrowBack != null) {
            return _ArrowBack!!
        }
        _ArrowBack = ImageVector.Builder(
            name = "Rounded.ArrowBack",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveToRelative(294.92f, 510f)
                lineToRelative(206.77f, 206.77f)
                quadToRelative(8.92f, 8.92f, 8.81f, 20.88f)
                quadToRelative(-0.12f, 11.96f, -9.42f, 21.27f)
                quadToRelative(-9.31f, 8.69f, -21.08f, 9f)
                quadToRelative(-11.77f, 0.31f, -21.08f, -9f)
                lineTo(205.31f, 505.31f)
                quadToRelative(-5.62f, -5.62f, -7.92f, -11.85f)
                quadToRelative(-2.31f, -6.23f, -2.31f, -13.46f)
                reflectiveQuadToRelative(2.31f, -13.46f)
                quadToRelative(2.3f, -6.23f, 7.92f, -11.85f)
                lineToRelative(253.61f, -253.61f)
                quadToRelative(8.31f, -8.31f, 20.58f, -8.5f)
                quadToRelative(12.27f, -0.19f, 21.58f, 8.5f)
                quadToRelative(9.3f, 9.31f, 9.3f, 21.38f)
                quadToRelative(0f, 12.08f, -9.3f, 21.39f)
                lineTo(294.92f, 450f)
                lineTo(750f, 450f)
                quadToRelative(12.77f, 0f, 21.38f, 8.62f)
                quadTo(780f, 467.23f, 780f, 480f)
                reflectiveQuadToRelative(-8.62f, 21.38f)
                quadTo(762.77f, 510f, 750f, 510f)
                lineTo(294.92f, 510f)
                close()
            }
        }.build()

        return _ArrowBack!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowBack: ImageVector? = null
