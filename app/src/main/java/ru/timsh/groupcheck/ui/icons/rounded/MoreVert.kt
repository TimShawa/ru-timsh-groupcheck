package ru.timsh.groupcheck.ui.icons.rounded

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.timsh.groupcheck.ui.icons.AppIcons

val AppIcons.Rounded.MoreVert: ImageVector
    get() {
        if (_MoreVert != null) {
            return _MoreVert!!
        }
        _MoreVert = ImageVector.Builder(
            name = "Rounded.MoreVert",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(480f, 770.77f)
                quadToRelative(-24.75f, 0f, -42.37f, -17.63f)
                quadTo(420f, 735.52f, 420f, 710.77f)
                quadToRelative(0f, -24.75f, 17.63f, -42.38f)
                quadToRelative(17.62f, -17.62f, 42.37f, -17.62f)
                quadToRelative(24.75f, 0f, 42.37f, 17.62f)
                quadTo(540f, 686.02f, 540f, 710.77f)
                quadToRelative(0f, 24.75f, -17.63f, 42.37f)
                quadToRelative(-17.62f, 17.63f, -42.37f, 17.63f)
                close()
                moveTo(480f, 540f)
                quadToRelative(-24.75f, 0f, -42.37f, -17.63f)
                quadTo(420f, 504.75f, 420f, 480f)
                quadToRelative(0f, -24.75f, 17.63f, -42.37f)
                quadTo(455.25f, 420f, 480f, 420f)
                quadToRelative(24.75f, 0f, 42.37f, 17.63f)
                quadTo(540f, 455.25f, 540f, 480f)
                quadToRelative(0f, 24.75f, -17.63f, 42.37f)
                quadTo(504.75f, 540f, 480f, 540f)
                close()
                moveTo(480f, 309.23f)
                quadToRelative(-24.75f, 0f, -42.37f, -17.62f)
                quadTo(420f, 273.98f, 420f, 249.23f)
                quadToRelative(0f, -24.75f, 17.63f, -42.37f)
                quadToRelative(17.62f, -17.63f, 42.37f, -17.63f)
                quadToRelative(24.75f, 0f, 42.37f, 17.63f)
                quadTo(540f, 224.48f, 540f, 249.23f)
                quadToRelative(0f, 24.75f, -17.63f, 42.38f)
                quadToRelative(-17.62f, 17.62f, -42.37f, 17.62f)
                close()
            }
        }.build()

        return _MoreVert!!
    }

@Suppress("ObjectPropertyName")
private var _MoreVert: ImageVector? = null
