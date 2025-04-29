package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.Edit: ImageVector
    get() {
        if (_Edit != null) {
            return _Edit!!
        }
        _Edit = ImageVector.Builder(
            name = "Rounded.Edit",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(200f, 760f)
                horizontalLineToRelative(50.46f)
                lineToRelative(409.46f, -409.46f)
                lineToRelative(-50.46f, -50.46f)
                lineTo(200f, 709.54f)
                lineTo(200f, 760f)
                close()
                moveTo(176.16f, 820f)
                quadToRelative(-15.37f, 0f, -25.76f, -10.4f)
                quadToRelative(-10.4f, -10.39f, -10.4f, -25.76f)
                verticalLineToRelative(-69.3f)
                quadToRelative(0f, -14.63f, 5.62f, -27.89f)
                quadToRelative(5.61f, -13.26f, 15.46f, -23.11f)
                lineToRelative(506.54f, -506.31f)
                quadToRelative(9.07f, -8.24f, 20.03f, -12.73f)
                quadToRelative(10.97f, -4.5f, 23f, -4.5f)
                reflectiveQuadToRelative(23.3f, 4.27f)
                quadToRelative(11.28f, 4.27f, 19.97f, 13.58f)
                lineToRelative(48.85f, 49.46f)
                quadToRelative(9.31f, 8.69f, 13.27f, 20f)
                quadToRelative(3.96f, 11.31f, 3.96f, 22.62f)
                quadToRelative(0f, 12.07f, -4.12f, 23.03f)
                quadToRelative(-4.12f, 10.97f, -13.11f, 20.04f)
                lineTo(296.46f, 798.92f)
                quadToRelative(-9.85f, 9.85f, -23.11f, 15.46f)
                quadToRelative(-13.26f, 5.62f, -27.89f, 5.62f)
                horizontalLineToRelative(-69.3f)
                close()
                moveTo(760.38f, 249.85f)
                lineTo(710.15f, 199.62f)
                lineTo(760.38f, 249.85f)
                close()
                moveTo(634.25f, 325.75f)
                lineTo(609.46f, 300.08f)
                lineTo(659.92f, 350.54f)
                lineTo(634.25f, 325.75f)
                close()
            }
        }.build()

        return _Edit!!
    }

@Suppress("ObjectPropertyName")
private var _Edit: ImageVector? = null
