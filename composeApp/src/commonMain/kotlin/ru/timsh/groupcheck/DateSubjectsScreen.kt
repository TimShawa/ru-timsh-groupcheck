@file:OptIn(ExperimentalSharedTransitionApi::class)

package ru.timsh.groupcheck

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateBounds
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import ru.timsh.groupcheck.ui.icons.Add
import ru.timsh.groupcheck.ui.icons.Alarm
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.Edit
import ru.timsh.groupcheck.ui.icons.MoreVert
import ru.timsh.groupcheck.ui.icons.StateLate
import ru.timsh.groupcheck.ui.icons.StateMissed
import ru.timsh.groupcheck.ui.icons.StateReasonable
import ru.timsh.groupcheck.ui.icons.StateVisited
import ru.timsh.groupcheck.ui.themes.apptheme.LocalExColorScheme
import ru.timsh.groupcheck.ui.themes.apptheme.extendedDark
import kotlin.time.TimeMark

@Composable
fun DateSubjectsScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            val lastIndex = DateSubjectsVM.subjectList.lastIndex
            for (i in 0..lastIndex) {
                SubjectCard(i)
            }
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxSize()
        ) {
            ExtendedFloatingActionButton(
                onClick = {},
                icon = {
                    Icon(AppIcons.Add, null)
                },
                text = {
                    Text("Add subject")
                },
                modifier = Modifier.padding(16.dp),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                expanded = DateSubjectsVM.expandedCardIndex == -1
            )
        }
    }
}


@Composable
private fun SubjectCard(
    index: Int
) {
    val expanded = DateSubjectsVM.expandedCardIndex == index
    val data = DateSubjectsVM.subjectList[index]
    OutlinedCard(
        onClick = {
            if (expanded) {
                DateSubjectsVM.expandedCardIndex = -1
            } else {
                DateSubjectsVM.expandedCardIndex = index
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            SubjectCardHeader(index, data, !expanded)
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(
                    animationSpec = tween(200),
                    expandFrom = Alignment.Bottom
                ) + fadeIn(tween(200)),
                exit = shrinkVertically(
                    animationSpec = tween(200),
                    shrinkTowards = Alignment.Bottom
                ) + fadeOut(tween(200))
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.height(8.dp))
                    SubjectCardTimeLabel(index, data)
                    Spacer(Modifier.height(8.dp))
                    SubjectCardBadges(index)
                    Spacer(Modifier.height(16.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Button(
                            onClick = {},
                        ) {
                            Text("Attendance")
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun SubjectCardHeader(
    index: Int,
    data: SubjectData,
    showTime: Boolean = true,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
            .height(48.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(48.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
        ) {
            Text(
                text = "${index + 1}",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        AnimatedContent(
            targetState = showTime,
            transitionSpec = {
                expandHorizontally(tween(200), expandFrom = Alignment.Start) +
                        fadeIn(tween(200)) togetherWith
                        shrinkHorizontally(tween(200), shrinkTowards = Alignment.Start) +
                        fadeOut(tween(200))
            },
            modifier = Modifier.weight(1f)
        ) { targetState ->
            if (targetState) {
                Column {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.height(24.dp),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = data.time,
                        modifier = Modifier.height(20.dp),
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
            else {
                Text(
                    text = data.name,
                    style = MaterialTheme.typography.headlineSmall,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        IconButton(
            onClick = {}
        ) {
            Icon(AppIcons.MoreVert, null)
        }
    }
}


@Composable
private fun SubjectCardTimeLabel(
    index: Int,
    data: SubjectData
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
            .height(40.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.minimumInteractiveComponentSize()
        ) {
            Icon(AppIcons.Alarm, null)
        }
        Text(
            text = "08:30 - 10:00",
            style = MaterialTheme.typography.bodyLarge
        )
        TextButton(
            onClick = {},
            modifier = Modifier.height(40.dp)
        ) {
            Text("Change")
        }
    }
}


@Composable
private fun  SubjectCardBadges(
    index: Int
) {
    var extendedColors = LocalExColorScheme.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var icons = listOf<ImageVector>(
            AppIcons.StateVisited,
            AppIcons.StateLate,
            AppIcons.StateMissed,
            AppIcons.StateReasonable
        )
        for (i in 0..3) {
            val containerColor = when (i) {
                0 -> extendedColors.visited.colorContainer
                1 -> extendedColors.late.colorContainer
                2 -> MaterialTheme.colorScheme.errorContainer
                else -> extendedColors.reasonable.colorContainer
            }
            val iconTint = when (i) {
                0 -> extendedColors.visited.color
                1 -> extendedColors.late.color
                2 -> MaterialTheme.colorScheme.error
                else -> extendedColors.reasonable.color
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(containerColor, CircleShape)
                    .height(30.dp)
                    .weight(1f)
            ) {
                Spacer(Modifier.width(4.dp))
                Icon(icons[i], null, tint = iconTint)
                Text(
                    text = "25",
                    style = MaterialTheme.typography.bodyMedium,
                    color = iconTint,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(8.dp))
            }
        }
    }
}



private object DateSubjectsVM: ViewModel() {
    var expandedCardIndex by mutableIntStateOf(0)
    var subjectList = mutableStateListOf<SubjectData>(
        SubjectData(),
        SubjectData(),
        SubjectData(),
        SubjectData(),
    )
}


class SubjectData {
    var name by mutableStateOf("Subject")
    var time by mutableStateOf("08:30 - 10:00")
    var studList = mutableStateListOf(null)
}
















