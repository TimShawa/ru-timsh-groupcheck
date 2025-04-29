package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Paste: ImageVector
    get() {
        if (_Paste != null) {
            return _Paste!!
        }
        _Paste = ImageVector.Builder(
            name = "Rounded.Paste",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(212.31f, 820f)
                quadToRelative(-29.83f, 0f, -51.07f, -21.24f)
                quadTo(140f, 777.52f, 140f, 747.69f)
                verticalLineToRelative(-535.38f)
                quadToRelative(0f, -29.83f, 21.24f, -51.07f)
                quadTo(182.48f, 140f, 212.31f, 140f)
                horizontalLineToRelative(176.23f)
                quadToRelative(8.31f, -29.23f, 33.96f, -48.46f)
                reflectiveQuadToRelative(57.5f, -19.23f)
                quadToRelative(33.08f, 0f, 58.42f, 19.23f)
                quadToRelative(25.35f, 19.23f, 33.66f, 48.46f)
                horizontalLineToRelative(175.61f)
                quadToRelative(29.83f, 0f, 51.07f, 21.24f)
                quadTo(820f, 182.48f, 820f, 212.31f)
                verticalLineToRelative(535.38f)
                quadToRelative(0f, 29.83f, -21.24f, 51.07f)
                quadTo(777.52f, 820f, 747.69f, 820f)
                lineTo(212.31f, 820f)
                close()
                moveTo(212.31f, 760f)
                horizontalLineToRelative(535.38f)
                quadToRelative(4.62f, 0f, 8.46f, -3.85f)
                quadToRelative(3.85f, -3.84f, 3.85f, -8.46f)
                verticalLineToRelative(-535.38f)
                quadToRelative(0f, -4.62f, -3.85f, -8.46f)
                quadToRelative(-3.84f, -3.85f, -8.46f, -3.85f)
                lineTo(660f, 200f)
                verticalLineToRelative(68.46f)
                quadToRelative(0f, 15.37f, -10.35f, 25.76f)
                quadToRelative(-10.35f, 10.39f, -25.65f, 10.39f)
                lineTo(335.99f, 304.61f)
                quadToRelative(-15.3f, 0f, -25.64f, -10.39f)
                quadTo(300f, 283.83f, 300f, 268.46f)
                lineTo(300f, 200f)
                horizontalLineToRelative(-87.69f)
                quadToRelative(-4.62f, 0f, -8.46f, 3.85f)
                quadToRelative(-3.85f, 3.84f, -3.85f, 8.46f)
                verticalLineToRelative(535.38f)
                quadToRelative(0f, 4.62f, 3.85f, 8.46f)
                quadToRelative(3.84f, 3.85f, 8.46f, 3.85f)
                close()
                moveTo(480.07f, 204.62f)
                quadToRelative(15.39f, 0f, 25.74f, -10.42f)
                quadToRelative(10.34f, -10.41f, 10.34f, -25.81f)
                quadToRelative(0f, -15.39f, -10.41f, -25.74f)
                quadToRelative(-10.41f, -10.34f, -25.81f, -10.34f)
                quadToRelative(-15.39f, 0f, -25.74f, 10.41f)
                quadToRelative(-10.34f, 10.42f, -10.34f, 25.81f)
                quadToRelative(0f, 15.39f, 10.41f, 25.74f)
                quadToRelative(10.41f, 10.35f, 25.81f, 10.35f)
                close()
            }
        }.build()

        return _Paste!!
    }

@Suppress("ObjectPropertyName")
private var _Paste: ImageVector? = null
