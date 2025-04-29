package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Info: ImageVector
    get() {
        if (_Info != null) {
            return _Info!!
        }
        _Info = ImageVector.Builder(
            name = "Rounded.Info",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(480.01f, 670f)
                quadToRelative(12.76f, 0f, 21.37f, -8.63f)
                quadTo(510f, 652.75f, 510f, 640f)
                verticalLineToRelative(-170f)
                quadToRelative(0f, -12.75f, -8.63f, -21.38f)
                quadToRelative(-8.63f, -8.62f, -21.38f, -8.62f)
                quadToRelative(-12.76f, 0f, -21.37f, 8.62f)
                quadTo(450f, 457.25f, 450f, 470f)
                verticalLineToRelative(170f)
                quadToRelative(0f, 12.75f, 8.63f, 21.37f)
                quadToRelative(8.63f, 8.63f, 21.38f, 8.63f)
                close()
                moveTo(480f, 371.54f)
                quadToRelative(13.73f, 0f, 23.02f, -9.29f)
                reflectiveQuadToRelative(9.29f, -23.02f)
                quadToRelative(0f, -13.73f, -9.29f, -23.02f)
                quadToRelative(-9.29f, -9.28f, -23.02f, -9.28f)
                reflectiveQuadToRelative(-23.02f, 9.28f)
                quadToRelative(-9.29f, 9.29f, -9.29f, 23.02f)
                reflectiveQuadToRelative(9.29f, 23.02f)
                quadToRelative(9.29f, 9.29f, 23.02f, 9.29f)
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

        return _Info!!
    }

@Suppress("ObjectPropertyName")
private var _Info: ImageVector? = null
