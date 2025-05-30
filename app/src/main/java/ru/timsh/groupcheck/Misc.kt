package ru.timsh.groupcheck

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp

@Composable
@NonRestartableComposable
internal fun RowScope.HSpacer(width: Dp, expand: Boolean = false) {
    if (expand) {
        Layout(measurePolicy = SpacerMeasurePolicy, modifier = Modifier.width(width).weight(1f))
    } else {
        Layout(measurePolicy = SpacerMeasurePolicy, modifier = Modifier.width(width))
    }
}

@Composable
@NonRestartableComposable
internal fun ColumnScope.VSpacer(height: Dp, expand: Boolean = false) {
    if (expand) {
        Layout(measurePolicy = SpacerMeasurePolicy, modifier = Modifier.height(height).weight(1f))
    } else {
        Layout(measurePolicy = SpacerMeasurePolicy, modifier = Modifier.height(height))
    }
}

private object SpacerMeasurePolicy : MeasurePolicy {

    override fun MeasureScope.measure(
        measurables: List<Measurable>,
        constraints: Constraints
    ): MeasureResult {
        return with(constraints) {
            val width = if (hasFixedWidth) maxWidth else 0
            val height = if (hasFixedHeight) maxHeight else 0
            layout(width, height) {}
        }
    }
}






























