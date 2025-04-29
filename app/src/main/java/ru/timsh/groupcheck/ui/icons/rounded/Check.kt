package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Check: ImageVector
    get() {
        if (_Check != null) {
            return _Check!!
        }
        _Check = ImageVector.Builder(
            name = "Rounded.Check",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveToRelative(382f, 620.62f)
                lineToRelative(345.54f, -345.54f)
                quadToRelative(8.92f, -8.93f, 20.88f, -9.12f)
                quadToRelative(11.96f, -0.19f, 21.27f, 9.12f)
                quadToRelative(9.31f, 9.31f, 9.31f, 21.38f)
                quadToRelative(0f, 12.08f, -9.31f, 21.39f)
                lineToRelative(-362.38f, 363f)
                quadToRelative(-10.85f, 10.84f, -25.31f, 10.84f)
                quadToRelative(-14.46f, 0f, -25.31f, -10.84f)
                lineToRelative(-167f, -167f)
                quadToRelative(-8.92f, -8.93f, -8.8f, -21.2f)
                quadToRelative(0.11f, -12.26f, 9.42f, -21.57f)
                reflectiveQuadToRelative(21.38f, -9.31f)
                quadToRelative(12.08f, 0f, 21.39f, 9.31f)
                lineTo(382f, 620.62f)
                close()
            }
        }.build()

        return _Check!!
    }

@Suppress("ObjectPropertyName")
private var _Check: ImageVector? = null
