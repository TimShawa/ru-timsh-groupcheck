package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.LastPage: ImageVector
    get() {
        if (_LastPage != null) {
            return _LastPage!!
        }
        _LastPage = ImageVector.Builder(
            name = "Rounded.LastPage",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(421.85f, 480f)
                lineTo(258.92f, 317.08f)
                quadToRelative(-8.3f, -8.31f, -8.5f, -20.89f)
                quadToRelative(-0.19f, -12.57f, 8.5f, -21.27f)
                quadToRelative(8.7f, -8.69f, 21.08f, -8.69f)
                quadToRelative(12.38f, 0f, 21.08f, 8.69f)
                lineToRelative(179.77f, 179.77f)
                quadToRelative(5.61f, 5.62f, 7.92f, 11.9f)
                quadToRelative(2.31f, 6.28f, 2.31f, 13.46f)
                quadToRelative(0f, 7.18f, -2.31f, 13.41f)
                reflectiveQuadToRelative(-7.92f, 11.85f)
                lineTo(301.08f, 685.08f)
                quadToRelative(-8.31f, 8.3f, -20.89f, 8.5f)
                quadToRelative(-12.57f, 0.19f, -21.27f, -8.5f)
                quadToRelative(-8.69f, -8.7f, -8.69f, -21.08f)
                quadToRelative(0f, -12.38f, 8.69f, -21.08f)
                lineTo(421.85f, 480f)
                close()
                moveTo(680.01f, 250f)
                quadToRelative(12.76f, 0f, 21.37f, 8.63f)
                quadTo(710f, 267.25f, 710f, 280f)
                verticalLineToRelative(400f)
                quadToRelative(0f, 12.75f, -8.63f, 21.37f)
                quadToRelative(-8.63f, 8.63f, -21.38f, 8.63f)
                quadToRelative(-12.76f, 0f, -21.37f, -8.63f)
                quadTo(650f, 692.75f, 650f, 680f)
                verticalLineToRelative(-400f)
                quadToRelative(0f, -12.75f, 8.63f, -21.37f)
                quadToRelative(8.63f, -8.63f, 21.38f, -8.63f)
                close()
            }
        }.build()

        return _LastPage!!
    }

@Suppress("ObjectPropertyName")
private var _LastPage: ImageVector? = null
