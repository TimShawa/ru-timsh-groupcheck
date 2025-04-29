package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.XAccountCircle: ImageVector
    get() {
        if (_XAccountCircle != null) {
            return _XAccountCircle!!
        }
        _XAccountCircle = ImageVector.Builder(
            name = "Rounded.XAccountCircle",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(240.92f, 691.69f)
                quadToRelative(51f, -37.84f, 111.12f, -59.77f)
                quadTo(412.15f, 610f, 480f, 610f)
                reflectiveQuadToRelative(127.96f, 21.92f)
                quadToRelative(60.12f, 21.93f, 111.12f, 59.77f)
                quadToRelative(37.3f, -41f, 59.11f, -94.92f)
                quadTo(800f, 542.85f, 800f, 480f)
                quadToRelative(0f, -133f, -93.5f, -226.5f)
                reflectiveQuadTo(480f, 160f)
                quadToRelative(-133f, 0f, -226.5f, 93.5f)
                reflectiveQuadTo(160f, 480f)
                quadToRelative(0f, 62.85f, 21.81f, 116.77f)
                quadToRelative(21.81f, 53.92f, 59.11f, 94.92f)
                close()
                moveTo(480f, 510f)
                quadToRelative(-54.77f, 0f, -92.38f, -37.62f)
                quadTo(350f, 434.77f, 350f, 380f)
                quadToRelative(0f, -54.77f, 37.62f, -92.38f)
                quadTo(425.23f, 250f, 480f, 250f)
                quadToRelative(54.77f, 0f, 92.38f, 37.62f)
                quadTo(610f, 325.23f, 610f, 380f)
                quadToRelative(0f, 54.77f, -37.62f, 92.38f)
                quadTo(534.77f, 510f, 480f, 510f)
                close()
                moveTo(480f, 860f)
                quadToRelative(-79.15f, 0f, -148.5f, -29.77f)
                reflectiveQuadToRelative(-120.65f, -81.08f)
                quadToRelative(-51.31f, -51.3f, -81.08f, -120.65f)
                quadTo(100f, 559.15f, 100f, 480f)
                reflectiveQuadToRelative(29.77f, -148.5f)
                quadToRelative(29.77f, -69.35f, 81.08f, -120.65f)
                quadToRelative(51.3f, -51.31f, 120.65f, -81.08f)
                quadTo(400.85f, 100f, 480f, 100f)
                reflectiveQuadToRelative(148.5f, 29.77f)
                quadToRelative(69.35f, 29.77f, 120.65f, 81.08f)
                quadToRelative(51.31f, 51.3f, 81.08f, 120.65f)
                quadTo(860f, 400.85f, 860f, 480f)
                reflectiveQuadToRelative(-29.77f, 148.5f)
                quadToRelative(-29.77f, 69.35f, -81.08f, 120.65f)
                quadToRelative(-51.3f, 51.31f, -120.65f, 81.08f)
                quadTo(559.15f, 860f, 480f, 860f)
                close()
            }
        }.build()

        return _XAccountCircle!!
    }

@Suppress("ObjectPropertyName")
private var _XAccountCircle: ImageVector? = null
