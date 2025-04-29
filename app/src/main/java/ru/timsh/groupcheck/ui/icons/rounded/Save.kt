package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Save: ImageVector
    get() {
        if (_Save != null) {
            return _Save!!
        }
        _Save = ImageVector.Builder(
            name = "Rounded.Save",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(212.31f, 820f)
                quadTo(182f, 820f, 161f, 799f)
                quadToRelative(-21f, -21f, -21f, -51.31f)
                verticalLineToRelative(-535.38f)
                quadTo(140f, 182f, 161f, 161f)
                quadToRelative(21f, -21f, 51.31f, -21f)
                horizontalLineToRelative(429.3f)
                quadToRelative(14.47f, 0f, 27.81f, 5.62f)
                quadToRelative(13.35f, 5.61f, 23.19f, 15.46f)
                lineToRelative(106.31f, 106.31f)
                quadToRelative(9.85f, 9.84f, 15.46f, 23.19f)
                quadToRelative(5.62f, 13.34f, 5.62f, 27.81f)
                verticalLineToRelative(429.3f)
                quadTo(820f, 778f, 799f, 799f)
                quadToRelative(-21f, 21f, -51.31f, 21f)
                lineTo(212.31f, 820f)
                close()
                moveTo(760f, 314f)
                lineTo(646f, 200f)
                lineTo(212.31f, 200f)
                quadToRelative(-5.39f, 0f, -8.85f, 3.46f)
                reflectiveQuadToRelative(-3.46f, 8.85f)
                verticalLineToRelative(535.38f)
                quadToRelative(0f, 5.39f, 3.46f, 8.85f)
                reflectiveQuadToRelative(8.85f, 3.46f)
                horizontalLineToRelative(535.38f)
                quadToRelative(5.39f, 0f, 8.85f, -3.46f)
                reflectiveQuadToRelative(3.46f, -8.85f)
                lineTo(760f, 314f)
                close()
                moveTo(480f, 690.77f)
                quadToRelative(41.54f, 0f, 70.77f, -29.23f)
                quadTo(580f, 632.31f, 580f, 590.77f)
                quadToRelative(0f, -41.54f, -29.23f, -70.77f)
                quadToRelative(-29.23f, -29.23f, -70.77f, -29.23f)
                quadToRelative(-41.54f, 0f, -70.77f, 29.23f)
                quadTo(380f, 549.23f, 380f, 590.77f)
                quadToRelative(0f, 41.54f, 29.23f, 70.77f)
                quadToRelative(29.23f, 29.23f, 70.77f, 29.23f)
                close()
                moveTo(291.54f, 395.38f)
                horizontalLineToRelative(256.15f)
                quadToRelative(15.46f, 0f, 25.81f, -10.34f)
                quadToRelative(10.34f, -10.35f, 10.34f, -25.81f)
                verticalLineToRelative(-67.69f)
                quadToRelative(0f, -15.46f, -10.34f, -25.81f)
                quadToRelative(-10.35f, -10.34f, -25.81f, -10.34f)
                lineTo(291.54f, 255.39f)
                quadToRelative(-15.46f, 0f, -25.81f, 10.34f)
                quadToRelative(-10.34f, 10.35f, -10.34f, 25.81f)
                verticalLineToRelative(67.69f)
                quadToRelative(0f, 15.46f, 10.34f, 25.81f)
                quadToRelative(10.35f, 10.34f, 25.81f, 10.34f)
                close()
                moveTo(200f, 314f)
                verticalLineToRelative(446f)
                verticalLineToRelative(-560f)
                verticalLineToRelative(114f)
                close()
            }
        }.build()

        return _Save!!
    }

@Suppress("ObjectPropertyName")
private var _Save: ImageVector? = null
