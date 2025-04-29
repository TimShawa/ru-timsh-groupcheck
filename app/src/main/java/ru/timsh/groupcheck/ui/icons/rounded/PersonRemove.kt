package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.PersonRemove: ImageVector
    get() {
        if (_PersonRemove != null) {
            return _PersonRemove!!
        }
        _PersonRemove = ImageVector.Builder(
            name = "Rounded.PersonRemove",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(672.31f, 370f)
                horizontalLineToRelative(160f)
                quadToRelative(12.75f, 0f, 21.37f, 8.63f)
                quadToRelative(8.63f, 8.63f, 8.63f, 21.38f)
                quadToRelative(0f, 12.76f, -8.63f, 21.37f)
                quadToRelative(-8.62f, 8.62f, -21.37f, 8.62f)
                horizontalLineToRelative(-160f)
                quadToRelative(-12.75f, 0f, -21.38f, -8.63f)
                quadToRelative(-8.62f, -8.63f, -8.62f, -21.38f)
                quadToRelative(0f, -12.76f, 8.62f, -21.37f)
                quadToRelative(8.63f, -8.62f, 21.38f, -8.62f)
                close()
                moveTo(360f, 467.69f)
                quadToRelative(-57.75f, 0f, -98.87f, -41.12f)
                quadTo(220f, 385.44f, 220f, 327.69f)
                quadToRelative(0f, -57.75f, 41.13f, -98.87f)
                quadToRelative(41.12f, -41.13f, 98.87f, -41.13f)
                quadToRelative(57.75f, 0f, 98.87f, 41.13f)
                quadTo(500f, 269.94f, 500f, 327.69f)
                quadToRelative(0f, 57.75f, -41.13f, 98.88f)
                quadToRelative(-41.12f, 41.12f, -98.87f, 41.12f)
                close()
                moveTo(60f, 711.54f)
                verticalLineToRelative(-28.16f)
                quadToRelative(0f, -29.38f, 15.96f, -54.42f)
                quadToRelative(15.96f, -25.04f, 42.66f, -38.5f)
                quadToRelative(59.3f, -29.07f, 119.65f, -43.61f)
                quadToRelative(60.35f, -14.54f, 121.73f, -14.54f)
                reflectiveQuadToRelative(121.73f, 14.54f)
                quadToRelative(60.35f, 14.54f, 119.65f, 43.61f)
                quadToRelative(26.7f, 13.46f, 42.66f, 38.5f)
                quadTo(660f, 654f, 660f, 683.38f)
                verticalLineToRelative(28.16f)
                quadToRelative(0f, 25.3f, -17.73f, 43.04f)
                quadToRelative(-17.73f, 17.73f, -43.04f, 17.73f)
                lineTo(120.77f, 772.31f)
                quadToRelative(-25.31f, 0f, -43.04f, -17.73f)
                quadTo(60f, 736.84f, 60f, 711.54f)
                close()
                moveTo(120f, 712.31f)
                horizontalLineToRelative(480f)
                verticalLineToRelative(-28.93f)
                quadToRelative(0f, -12.15f, -7.04f, -22.5f)
                quadToRelative(-7.04f, -10.34f, -19.11f, -16.88f)
                quadToRelative(-51.7f, -25.46f, -105.42f, -38.58f)
                quadTo(414.7f, 592.31f, 360f, 592.31f)
                quadToRelative(-54.7f, 0f, -108.43f, 13.11f)
                quadToRelative(-53.72f, 13.12f, -105.42f, 38.58f)
                quadToRelative(-12.07f, 6.54f, -19.11f, 16.88f)
                quadToRelative(-7.04f, 10.35f, -7.04f, 22.5f)
                verticalLineToRelative(28.93f)
                close()
                moveTo(360f, 407.69f)
                quadToRelative(33f, 0f, 56.5f, -23.5f)
                reflectiveQuadToRelative(23.5f, -56.5f)
                quadToRelative(0f, -33f, -23.5f, -56.5f)
                reflectiveQuadToRelative(-56.5f, -23.5f)
                quadToRelative(-33f, 0f, -56.5f, 23.5f)
                reflectiveQuadToRelative(-23.5f, 56.5f)
                quadToRelative(0f, 33f, 23.5f, 56.5f)
                reflectiveQuadToRelative(56.5f, 23.5f)
                close()
                moveTo(360f, 327.69f)
                close()
                moveTo(360f, 712.31f)
                close()
            }
        }.build()

        return _PersonRemove!!
    }

@Suppress("ObjectPropertyName")
private var _PersonRemove: ImageVector? = null
