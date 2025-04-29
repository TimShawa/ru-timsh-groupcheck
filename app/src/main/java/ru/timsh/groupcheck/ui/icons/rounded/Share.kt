package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Share: ImageVector
    get() {
        if (_Share != null) {
            return _Share!!
        }
        _Share = ImageVector.Builder(
            name = "Rounded.Share",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(672.22f, 860f)
                quadToRelative(-44.91f, 0f, -76.26f, -31.41f)
                quadToRelative(-31.34f, -31.41f, -31.34f, -76.28f)
                quadToRelative(0f, -6f, 4.15f, -29.16f)
                lineTo(284.31f, 555.69f)
                quadToRelative(-14.46f, 15f, -34.36f, 23.5f)
                reflectiveQuadToRelative(-42.64f, 8.5f)
                quadToRelative(-44.71f, 0f, -76.01f, -31.54f)
                quadTo(100f, 524.61f, 100f, 480f)
                quadToRelative(0f, -44.61f, 31.3f, -76.15f)
                quadToRelative(31.3f, -31.54f, 76.01f, -31.54f)
                quadToRelative(22.74f, 0f, 42.64f, 8.5f)
                quadToRelative(19.9f, 8.5f, 34.36f, 23.5f)
                lineToRelative(284.46f, -167.08f)
                quadToRelative(-2.38f, -7.38f, -3.27f, -14.46f)
                quadToRelative(-0.88f, -7.08f, -0.88f, -15.08f)
                quadToRelative(0f, -44.87f, 31.43f, -76.28f)
                quadTo(627.49f, 100f, 672.4f, 100f)
                reflectiveQuadToRelative(76.25f, 31.44f)
                quadTo(780f, 162.87f, 780f, 207.78f)
                quadToRelative(0f, 44.91f, -31.41f, 76.26f)
                quadToRelative(-31.41f, 31.34f, -76.28f, 31.34f)
                quadToRelative(-22.85f, 0f, -42.5f, -8.69f)
                quadTo(610.15f, 298f, 595.69f, 283f)
                lineTo(311.23f, 450.46f)
                quadToRelative(2.38f, 7.39f, 3.27f, 14.46f)
                quadToRelative(0.88f, 7.08f, 0.88f, 15.08f)
                reflectiveQuadToRelative(-0.88f, 15.08f)
                quadToRelative(-0.89f, 7.07f, -3.27f, 14.46f)
                lineTo(595.69f, 677f)
                quadToRelative(14.46f, -15f, 34.12f, -23.69f)
                quadToRelative(19.65f, -8.69f, 42.5f, -8.69f)
                quadToRelative(44.87f, 0f, 76.28f, 31.43f)
                quadTo(780f, 707.49f, 780f, 752.4f)
                reflectiveQuadToRelative(-31.44f, 76.25f)
                quadTo(717.13f, 860f, 672.22f, 860f)
                close()
                moveTo(672.31f, 800f)
                quadToRelative(20.27f, 0f, 33.98f, -13.71f)
                quadTo(720f, 772.58f, 720f, 752.31f)
                quadToRelative(0f, -20.27f, -13.71f, -33.98f)
                quadToRelative(-13.71f, -13.72f, -33.98f, -13.72f)
                quadToRelative(-20.27f, 0f, -33.98f, 13.72f)
                quadToRelative(-13.72f, 13.71f, -13.72f, 33.98f)
                quadToRelative(0f, 20.27f, 13.72f, 33.98f)
                quadTo(652.04f, 800f, 672.31f, 800f)
                close()
                moveTo(207.31f, 527.69f)
                quadToRelative(20.43f, 0f, 34.25f, -13.71f)
                quadToRelative(13.83f, -13.71f, 13.83f, -33.98f)
                quadToRelative(0f, -20.27f, -13.83f, -33.98f)
                quadToRelative(-13.82f, -13.71f, -34.25f, -13.71f)
                quadToRelative(-20.11f, 0f, -33.71f, 13.71f)
                quadTo(160f, 459.73f, 160f, 480f)
                quadToRelative(0f, 20.27f, 13.6f, 33.98f)
                quadToRelative(13.6f, 13.71f, 33.71f, 13.71f)
                close()
                moveTo(672.31f, 255.39f)
                quadToRelative(20.27f, 0f, 33.98f, -13.72f)
                quadTo(720f, 227.96f, 720f, 207.69f)
                quadToRelative(0f, -20.27f, -13.71f, -33.98f)
                quadTo(692.58f, 160f, 672.31f, 160f)
                quadToRelative(-20.27f, 0f, -33.98f, 13.71f)
                quadToRelative(-13.72f, 13.71f, -13.72f, 33.98f)
                quadToRelative(0f, 20.27f, 13.72f, 33.98f)
                quadToRelative(13.71f, 13.72f, 33.98f, 13.72f)
                close()
                moveTo(672.31f, 752.31f)
                close()
                moveTo(207.69f, 480f)
                close()
                moveTo(672.31f, 207.69f)
                close()
            }
        }.build()

        return _Share!!
    }

@Suppress("ObjectPropertyName")
private var _Share: ImageVector? = null
