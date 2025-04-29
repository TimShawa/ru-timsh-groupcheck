package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.XStatusReasonable: ImageVector
    get() {
        if (_XStatusReasonable != null) {
            return _XStatusReasonable!!
        }
        _XStatusReasonable = ImageVector.Builder(
            name = "Rounded.XStatusReasonable",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(320f, 510f)
                horizontalLineToRelative(320f)
                quadToRelative(12.75f, 0f, 21.37f, -8.63f)
                quadToRelative(8.63f, -8.63f, 8.63f, -21.38f)
                quadToRelative(0f, -12.76f, -8.63f, -21.37f)
                quadTo(652.75f, 450f, 640f, 450f)
                lineTo(320f, 450f)
                quadToRelative(-12.75f, 0f, -21.37f, 8.63f)
                quadToRelative(-8.63f, 8.63f, -8.63f, 21.38f)
                quadToRelative(0f, 12.76f, 8.63f, 21.37f)
                quadTo(307.25f, 510f, 320f, 510f)
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
            }
        }.build()

        return _XStatusReasonable!!
    }

@Suppress("ObjectPropertyName")
private var _XStatusReasonable: ImageVector? = null
