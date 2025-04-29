package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.AccountCircle: ImageVector
    get() {
        if (_AccountCircle != null) {
            return _AccountCircle!!
        }
        _AccountCircle = ImageVector.Builder(
            name = "Rounded.AccountCircle",
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
                moveTo(480.01f, 510f)
                quadToRelative(-54.78f, 0f, -92.39f, -37.6f)
                quadTo(350f, 434.79f, 350f, 380.01f)
                reflectiveQuadToRelative(37.6f, -92.39f)
                quadTo(425.21f, 250f, 479.99f, 250f)
                reflectiveQuadToRelative(92.39f, 37.6f)
                quadTo(610f, 325.21f, 610f, 379.99f)
                reflectiveQuadToRelative(-37.6f, 92.39f)
                quadTo(534.79f, 510f, 480.01f, 510f)
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
                moveTo(480f, 800f)
                quadToRelative(54.15f, 0f, 104.42f, -17.42f)
                quadToRelative(50.27f, -17.43f, 89.27f, -48.73f)
                quadToRelative(-39f, -30.16f, -88.11f, -47f)
                quadTo(536.46f, 670f, 480f, 670f)
                reflectiveQuadToRelative(-105.77f, 16.65f)
                quadToRelative(-49.31f, 16.66f, -87.92f, 47.2f)
                quadToRelative(39f, 31.3f, 89.27f, 48.73f)
                quadTo(425.85f, 800f, 480f, 800f)
                close()
                moveTo(480f, 450f)
                quadToRelative(29.85f, 0f, 49.92f, -20.08f)
                quadTo(550f, 409.85f, 550f, 380f)
                reflectiveQuadToRelative(-20.08f, -49.92f)
                quadTo(509.85f, 310f, 480f, 310f)
                reflectiveQuadToRelative(-49.92f, 20.08f)
                quadTo(410f, 350.15f, 410f, 380f)
                reflectiveQuadToRelative(20.08f, 49.92f)
                quadTo(450.15f, 450f, 480f, 450f)
                close()
                moveTo(480f, 380f)
                close()
                moveTo(480f, 735f)
                close()
            }
        }.build()

        return _AccountCircle!!
    }

@Suppress("ObjectPropertyName")
private var _AccountCircle: ImageVector? = null
