package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Open: ImageVector
    get() {
        if (_Open != null) {
            return _Open!!
        }
        _Open = ImageVector.Builder(
            name = "Rounded.Open",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(170f, 780f)
                quadToRelative(-29.15f, 0f, -49.58f, -20.42f)
                quadTo(100f, 739.15f, 100f, 710f)
                verticalLineToRelative(-457.69f)
                quadToRelative(0f, -29.15f, 21.58f, -50.73f)
                reflectiveQuadTo(172.31f, 180f)
                lineTo(362f, 180f)
                quadToRelative(14.46f, 0f, 27.81f, 5.62f)
                quadToRelative(13.34f, 5.61f, 23.19f, 15.46f)
                lineTo(471.92f, 260f)
                horizontalLineToRelative(354.62f)
                quadToRelative(12.77f, 0f, 21.38f, 8.62f)
                quadToRelative(8.62f, 8.61f, 8.62f, 21.38f)
                reflectiveQuadToRelative(-8.62f, 21.38f)
                quadToRelative(-8.61f, 8.62f, -21.38f, 8.62f)
                lineTo(447.38f, 320f)
                lineToRelative(-80f, -80f)
                lineTo(172.31f, 240f)
                quadToRelative(-5.39f, 0f, -8.85f, 3.46f)
                reflectiveQuadToRelative(-3.46f, 8.85f)
                lineTo(160f, 720f)
                quadToRelative(0f, -5.39f, 2.12f, -4.04f)
                quadToRelative(2.11f, 1.35f, 5.57f, 3.27f)
                lineToRelative(77.85f, -259.92f)
                quadToRelative(7.23f, -23.31f, 26.61f, -37.46f)
                quadToRelative(19.39f, -14.16f, 43.08f, -14.16f)
                horizontalLineToRelative(514.46f)
                quadToRelative(36.77f, 0f, 58.35f, 29.23f)
                quadToRelative(21.57f, 29.23f, 11.34f, 63.77f)
                lineToRelative(-68.92f, 229.62f)
                quadToRelative(-6.85f, 22.53f, -25.65f, 36.11f)
                quadTo(786f, 780f, 763.08f, 780f)
                lineTo(170f, 780f)
                close()
                moveTo(230.54f, 720f)
                horizontalLineToRelative(531f)
                quadToRelative(4.23f, 0f, 7.5f, -2.31f)
                quadToRelative(3.27f, -2.31f, 4.42f, -6.54f)
                lineToRelative(68.16f, -227.69f)
                quadToRelative(1.92f, -6.15f, -1.93f, -10.96f)
                quadToRelative(-3.84f, -4.81f, -10f, -4.81f)
                lineTo(315.23f, 467.69f)
                quadToRelative(-4.23f, 0f, -7.5f, 2.31f)
                quadToRelative(-3.27f, 2.31f, -4.42f, 6.54f)
                lineTo(230.54f, 720f)
                close()
                moveTo(160f, 459.92f)
                lineTo(160f, 240f)
                lineTo(160f, 459.92f)
                close()
                moveTo(230.54f, 720f)
                lineToRelative(72.77f, -243.46f)
                quadToRelative(1.15f, -4.23f, 1.92f, -6.54f)
                lineToRelative(0.77f, -2.31f)
                lineToRelative(-1.35f, 4.81f)
                quadToRelative(-1.34f, 4.81f, -3.27f, 10.96f)
                lineToRelative(-68.15f, 227.69f)
                quadToRelative(-1.15f, 4.23f, -1.92f, 6.54f)
                lineToRelative(-0.77f, 2.31f)
                close()
            }
        }.build()

        return _Open!!
    }

@Suppress("ObjectPropertyName")
private var _Open: ImageVector? = null
