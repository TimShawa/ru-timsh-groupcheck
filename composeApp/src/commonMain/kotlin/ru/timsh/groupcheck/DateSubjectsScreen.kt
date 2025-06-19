@file:OptIn(ExperimentalSharedTransitionApi::class)

package ru.timsh.groupcheck

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import ru.timsh.groupcheck.database.Subjects
import ru.timsh.groupcheck.database.journalDAO
import ru.timsh.groupcheck.ui.icons.Add
import ru.timsh.groupcheck.ui.icons.Alarm
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.MoreVert
import ru.timsh.groupcheck.ui.icons.StateMissed
import ru.timsh.groupcheck.ui.icons.StateReasonable
import ru.timsh.groupcheck.ui.icons.StateVisited
import ru.timsh.groupcheck.ui.themes.apptheme.LocalExColorScheme


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
//            var lastIndex = DateSubjectsVM.subjectList.lastIndex
            val subjects by journalDAO.selectSubjectsFromDate(
                "18.06.2025"
            ).collectAsState(initial = emptyList())
            if (subjects.isNotEmpty()) {
                for (i in 0..subjects.lastIndex) {
                    SubjectCard(i, subjects[i].entryID)
                }
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
    index: Int,
    subjectID: Int
) {
    val expanded = DateSubjectsVM.expandedCardIndex == index
    val query by journalDAO.selectSubjectFromID(subjectID)
        .collectAsState(initial = emptyList())

    if (query.isEmpty()) {
        return
    }

    val data = query[0]

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
            SubjectCardHeader(index, data, expanded)
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
                    SubjectCardBadges(data.date, index)
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
    data: Subjects,
    expanded: Boolean,
) {
    val headlineSize by animateIntAsState(
        targetValue = if (expanded) 24 else 18
    )
    val headlineColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
            .size(48.dp)
    ) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) {
            if (it) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(48.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
                ) {
                    Text(
                        text = "${data.dailyIndex + 1}",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            } else {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(48.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Text(
                        text = "${data.dailyIndex + 1}",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        Text(
            text = data.subjectName,
            style = MaterialTheme.typography.headlineSmall,
            fontSize = headlineSize.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
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
    data: Subjects
) {
    val beginTime = buildTimeString(data.beginTime)
    val endTime = buildTimeString(data.endTime)
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
            text = "$beginTime - $endTime",
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
    date: String,
    index: Int,
) {
    var extendedColors = LocalExColorScheme.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var icons = listOf<ImageVector>(
            AppIcons.StateVisited,
            AppIcons.StateMissed,
            AppIcons.StateReasonable
        )
        for (i in 0..2) {
            val containerColor = when (i) {
                0 -> extendedColors.visited.colorContainer
                1 -> MaterialTheme.colorScheme.errorContainer
                else -> extendedColors.reasonable.colorContainer
            }
            val iconTint = when (i) {
                0 -> extendedColors.visited.color
                1 -> MaterialTheme.colorScheme.error
                else -> extendedColors.reasonable.color
            }
            val counterText = "${ when (i) {
                0 -> journalDAO.countVisistedFromDateSubject(date, index).collectAsState(0).value
                1 -> journalDAO.countMissedFromDateSubject(date, index).collectAsState(0).value
                else -> journalDAO.countPassedDateSubject(date, index).collectAsState(0).value
            } }/${
                journalDAO.countFromDateSubject(date, index).collectAsState(0).value
            }"
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
                    text = counterText,
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


private fun buildTimeString(time: Int): String {
    val use24H: Boolean = true
    var hh = "${time / 100}".padStart(2, '0')
    var mm = "${time % 100}".padStart(2, '0')
    var h12 = "${(time / 100) % 12}".padStart(2, '0')
    val ampm = if ((time / 100) >= 12) "p.m." else "a.m."
    return if (use24H) {
        "$hh:$mm"
    } else {
        "$h12:$mm $ampm"
    }
}


expect fun logD(tag: String, message: String)










