package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.StatusVisited: ImageVector
    get() {
        if (_StatusVisited != null) {
            return _StatusVisited!!
        }
        _StatusVisited = ImageVector.Builder(
            name = "Rounded.StatusVisited",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveToRelative(423.23f, 565.85f)
                lineToRelative(-92.92f, -92.93f)
                quadToRelative(-8.31f, -8.3f, -20.89f, -8.5f)
                quadToRelative(-12.57f, -0.19f, -21.27f, 8.5f)
                quadToRelative(-8.69f, 8.7f, -8.69f, 21.08f)
                quadToRelative(0f, 12.38f, 8.69f, 21.08f)
                lineToRelative(109.77f, 109.77f)
                quadToRelative(10.85f, 10.84f, 25.31f, 10.84f)
                quadToRelative(14.46f, 0f, 25.31f, -10.84f)
                lineToRelative(222.54f, -222.54f)
                quadToRelative(8.3f, -8.31f, 8.5f, -20.89f)
                quadToRelative(0.19f, -12.57f, -8.5f, -21.27f)
                quadToRelative(-8.7f, -8.69f, -21.08f, -8.69f)
                quadToRelative(-12.38f, 0f, -21.08f, 8.69f)
                lineToRelative(-205.69f, 205.7f)
                close()
                moveTo(480.07f, 860f)
                quadToRelative(-78.84f, 0f, -148.21f, -29.92f)
                reflectiveQuadToRelative(-120.68f, -81.21f)
                quadToRelative(-51.31f, -51.29f, -81.25f, -120.63f)
                quadTo(100f, 558.9f, 100f, 480.07f)
                quadToRelative(0f, -78.84f, 29.92f, -148.21f)
                reflectiveQuadToRelative(81.21f, -120.68f)
                quadToRelative(51.29f, -51.31f, 120.63f, -81.25f)
                quadTo(401.1f, 100f, 479.93f, 100f)
                quadToRelative(78.84f, 0f, 148.21f, 29.92f)
                reflectiveQuadToRelative(120.68f, 81.21f)
                quadToRelative(51.31f, 51.29f, 81.25f, 120.63f)
                quadTo(860f, 401.1f, 860f, 479.93f)
                quadToRelative(0f, 78.84f, -29.92f, 148.21f)
                reflectiveQuadToRelative(-81.21f, 120.68f)
                quadToRelative(-51.29f, 51.31f, -120.63f, 81.25f)
                quadTo(558.9f, 860f, 480.07f, 860f)
                close()
                moveTo(480f, 800f)
                quadToRelative(134f, 0f, 227f, -93f)
                reflectiveQuadToRelative(93f, -227f)
                quadToRelative(0f, -134f, -93f, -227f)
                reflectiveQuadToRelative(-227f, -93f)
                quadToRelative(-134f, 0f, -227f, 93f)
                reflectiveQuadToRelative(-93f, 227f)
                quadToRelative(0f, 134f, 93f, 227f)
                reflectiveQuadToRelative(227f, 93f)
                close()
                moveTo(480f, 480f)
                close()
            }
        }.build()

        return _StatusVisited!!
    }

@Suppress("ObjectPropertyName")
private var _StatusVisited: ImageVector? = null
