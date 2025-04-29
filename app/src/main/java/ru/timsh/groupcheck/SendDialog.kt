@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalSharedTransitionApi::class
)

package ru.timsh.groupcheck

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.rounded.ArrowBack
import ru.timsh.groupcheck.ui.icons.rounded.KeyboardArrowDown
import ru.timsh.groupcheck.ui.icons.rounded.KeyboardArrowUp
import ru.timsh.groupcheck.ui.icons.rounded.StatusLate
import ru.timsh.groupcheck.ui.icons.rounded.StatusMissed
import ru.timsh.groupcheck.ui.icons.rounded.StatusReasonable
import ru.timsh.groupcheck.ui.icons.rounded.StatusVisited
import ru.timsh.groupcheck.ui.icons.rounded.XSend
import ru.timsh.groupcheck.ui.icons.rounded.XStatusLate
import ru.timsh.groupcheck.ui.icons.rounded.XStatusMissed
import ru.timsh.groupcheck.ui.icons.rounded.XStatusReasonable
import ru.timsh.groupcheck.ui.icons.rounded.XStatusVisited


@Composable
fun SharedTransitionScope.SendPage(
    sharedAVS: AnimatedVisibilityScope
) {
    sendVM.apply {
        showOptions = true
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.send_page_title)) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            appVM.navController!!.navigateUp()
                        }
                    ) {
                        Icon(imageVector = AppIcons.Rounded.ArrowBack, null)
                    }
                },
                actions = {
                    Crossfade(sendVM.showOptions) {
                        if (it) {
                            IconButton(
                                onClick = {
                                    sendVM.showOptions = !sendVM.showOptions
                                }
                            ) {
                                Icon(AppIcons.Rounded.KeyboardArrowUp, null)
                            }
                        } else {
                            IconButton(
                                onClick = {
                                    sendVM.showOptions = !sendVM.showOptions
                                }
                            ) {
                                Icon(AppIcons.Rounded.KeyboardArrowDown, null)
                            }
                        }
                    }
                }
            )
        },
        modifier = Modifier.sharedBounds(
                sharedContentState = rememberSharedContentState("FAB_EXPLODE_SHARE"),
                animatedVisibilityScope = sharedAVS
            )
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Box(
                Modifier.padding(innerPadding)
                    .consumeWindowInsets(innerPadding),
            ) {
                var text = buildSendText()
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Spacer(Modifier.weight(1f))
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        shadowElevation = 1.dp,
                        modifier = Modifier
                            .padding(16.dp, 4.dp)
                            .wrapContentHeight(unbounded = true)
                    ) {
                        Box(Modifier.padding(16.dp, 8.dp)) {
                            if (text.isNotEmpty()) {
                                Text(text)
                            } else {
                                Text(
                                    text = stringResource(R.string.send_preview_typing),
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                    }
                    BottomBar()
                }

                AnimatedVisibility(
                    visible = sendVM.showOptions,
                    enter = slideInVertically { -it } +
                            fadeIn(),
                    exit = slideOutVertically { -it } +
                            fadeOut()
                ) {
                    Surface(
                        shadowElevation = 1.dp,
                        shape = MaterialTheme.shapes.large.copy(
                            topStart = CornerSize(0),
                            topEnd = CornerSize(0)
                        )
                    ) {
                        Column(
                            Modifier.padding(16.dp, 8.dp)
                        ) {
                            OptionFilters()
                            VSpacer(16.dp)
                            OptionTextFormat()
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun BottomBar() {
    var doSend by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(
        modifier = Modifier.padding(0.dp, 8.dp)
            .pointerInput(Unit) {

            }
    ) {
        HSpacer(8.dp)
        Surface(
            shape = CircleShape,
            shadowElevation = 1.dp,
            modifier = Modifier.weight(1f)
        ) {
            BasicTextField(
                singleLine = true,
                modifier = Modifier.weight(1f),
                value = sendVM.leadingText,
                onValueChange = { sendVM.leadingText = it },
                cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant),
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(
                    onSend = {
                        keyboardController?.hide()
                        doSend = true
                    }
                ),
                decorationBox = { innerTextField ->
                    var text = sendVM.leadingText
                    Box(
                        modifier = Modifier.padding(16.dp, 10.dp)
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = stringResource(R.string.send_leading_text),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.outline,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
        HSpacer(8.dp)
        Surface(
            shadowElevation = 2.dp,
            shape = IconButtonDefaults.filledShape,
            color = MaterialTheme.colorScheme.primary
        ) {
            IconButton(
                onClick = { doSend = true },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = AppIcons.Rounded.XSend,
                    contentDescription = null,
                )
            }
        }
        HSpacer(8.dp)
    }
    if (doSend) {
        SendFormattedText()
        doSend = false
    }
}


@Composable
private fun OptionFilters() {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = sendVM.includeVisited,
            onClick = { sendVM.includeVisited = !sendVM.includeVisited },
            leadingIcon = {
                Crossfade(sendVM.includeVisited, animationSpec = tween(200)) { selected ->
                    if (selected) {
                        Icon(imageVector = AppIcons.Rounded.XStatusVisited, null, tint = MaterialTheme.colorScheme.primary)
                    } else {
                        Icon(imageVector = AppIcons.Rounded.StatusVisited, null)
                    }
                }
            },
            label = { Text(stringResource(R.string.status_visited_filter)) },
//            modifier = Modifier.height(28.dp)
        )
        FilterChip(
            selected = sendVM.includeLate,
            onClick = { sendVM.includeLate = !sendVM.includeLate },
            leadingIcon = {
                Crossfade(sendVM.includeLate, animationSpec = tween(200)) { selected ->
                    if (selected) {
                        Icon(imageVector = AppIcons.Rounded.XStatusLate, null, tint = MaterialTheme.colorScheme.primary)
                    } else {
                        Icon(imageVector = AppIcons.Rounded.StatusLate, null)
                    }
                }
            },
            label = { Text(stringResource(R.string.status_late_filter)) }
        )
        FilterChip(
            selected = sendVM.includeMissed,
            onClick = { sendVM.includeMissed = !sendVM.includeMissed },
            leadingIcon = {
                Crossfade(sendVM.includeMissed, animationSpec = tween(200)) { selected ->
                    if (selected) {
                        Icon(imageVector = AppIcons.Rounded.XStatusMissed, null, tint = MaterialTheme.colorScheme.primary)
                    } else {
                        Icon(imageVector = AppIcons.Rounded.StatusMissed, null)
                    }
                }
            },
            label = { Text(stringResource(R.string.status_missed_filter)) }
        )
        FilterChip(
            selected = sendVM.includeReasonable,
            onClick = { sendVM.includeReasonable = !sendVM.includeReasonable },
            leadingIcon = {
                Crossfade(sendVM.includeReasonable, animationSpec = tween(200)) { selected ->
                    if (selected) {
                        Icon(imageVector = AppIcons.Rounded.XStatusReasonable, null, tint = MaterialTheme.colorScheme.primary)
                    } else {
                        Icon(imageVector = AppIcons.Rounded.StatusReasonable, null)
                    }
                }
            },
            label = { Text(stringResource(R.string.status_reasonable_filter)) }
        )
    }
}


@Composable
private fun OptionTextFormat() {
    Text(stringResource(R.string.send_option_format))
    val inlineInteraction = remember { MutableInteractionSource() }
    val inlineAction = { sendVM.format = SendFormat.INLINE }
    val listedInteraction = remember { MutableInteractionSource() }
    val listedAction = { sendVM.format = SendFormat.SEPARATE }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = inlineAction,
                interactionSource = inlineInteraction,
                indication = null //LocalIndication.current
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = (sendVM.format == SendFormat.INLINE),
            onClick = inlineAction,
            interactionSource = inlineInteraction
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = stringResource(R.string.send_format_inline),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = listedAction,
                interactionSource = listedInteraction,
                indication = null //LocalIndication.current
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = (sendVM.format == SendFormat.SEPARATE),
            onClick = listedAction,
            interactionSource = listedInteraction
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = stringResource(R.string.send_format_listed),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    OptionsExtra()
}


@Composable
private fun OptionsExtra() {
    val fieldTakeLateAsMiss: Boolean = (sendVM.includeLate || sendVM.includeMissed)
    val fieldAlwaysMarkMissed: Boolean = (sendVM.includeMissed)
    Spacer(Modifier.width(16.dp))
    Text(stringResource(R.string.send_option_other))
    val lateMissInteraction = remember { MutableInteractionSource() }
    val lateMissAction = { sendVM.takeLateAsMiss = !sendVM.takeLateAsMiss }

    var takeLateAsMiss: @Composable (Boolean) -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = lateMissAction,
                    enabled = fieldTakeLateAsMiss,
                    interactionSource = lateMissInteraction,
                    indication = null
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = sendVM.takeLateAsMiss,
                enabled = it,
                onCheckedChange = { lateMissAction() },
                interactionSource = lateMissInteraction
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.send_option_late_as_miss),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = if (it) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.outline
                }
            )
        }
    }
    Crossfade(fieldTakeLateAsMiss, animationSpec = tween(200)) {
        takeLateAsMiss(it)
    }
    val markMissInteraction = remember { MutableInteractionSource() }
    val markMissAction = { sendVM.alwaysMarkMissed = !sendVM.alwaysMarkMissed }
    var alwaysMarkMissed: @Composable (Boolean) -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = markMissAction,
                    enabled = it,
                    interactionSource = markMissInteraction,
                    indication = null
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = sendVM.alwaysMarkMissed,
                enabled = it,
                onCheckedChange = { markMissAction() },
                interactionSource = markMissInteraction
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.send_option_always_mark_missed) + " " + stringResource(
                    R.string.status_missed_suffix
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = if (it) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.outline
                }
            )
        }
    }
    Crossfade(fieldAlwaysMarkMissed, animationSpec = tween(200)) {
        alwaysMarkMissed(it)
    }
}


private class SendModel: ViewModel() {
    var leadingText: String by mutableStateOf("")
    var includeVisited: Boolean by mutableStateOf(false)
    var includeLate: Boolean by mutableStateOf(true)
    var includeReasonable: Boolean by mutableStateOf(true)
    var includeMissed: Boolean by mutableStateOf(true)
    var format: SendFormat by mutableStateOf(SendFormat.INLINE)
    var takeLateAsMiss: Boolean by mutableStateOf(false)
    var alwaysMarkMissed: Boolean by mutableStateOf(true)
    var showOptions: Boolean by mutableStateOf(true)
}


private var sendVM: SendModel = SendModel()


private enum class SendFormat {
    INLINE,
    SEPARATE
}


@Composable
private fun buildSendText(): String {
    var list = mutableListOf<String>()
    for (stud in appVM.studList) {
        var status = stud.status
        if (sendVM.takeLateAsMiss) {
            if (status == StudStatus.LATE) {
                status = StudStatus.MISSED
            }
        }
        when (status) {
            StudStatus.VISITED -> {
                if (sendVM.includeVisited) {
                    list.add(stud.displayName)
                }
            }
            StudStatus.LATE -> {
                if (sendVM.includeLate) {
                    if (sendVM.includeVisited || sendVM.includeMissed || sendVM.includeReasonable) {
                        list.add(stud.displayName + " " + stringResource(R.string.status_late_suffix))
                    } else {
                        list.add(stud.displayName)
                    }
                }
            }
            StudStatus.MISSED -> {
                if (sendVM.includeMissed) {
                    if (sendVM.alwaysMarkMissed || sendVM.includeVisited) {
                        list.add(stud.displayName + " " + stringResource(R.string.status_missed_suffix))
                    } else {
                        list.add(stud.displayName)
                    }
                }
            }
            StudStatus.REASONABLE -> {
                if (sendVM.includeReasonable) {
                    if (sendVM.includeVisited || sendVM.includeLate || sendVM.includeMissed) {
                        list.add(stud.displayName + " " + stringResource(R.string.status_reasonable_suffix))
                    } else {
                        list.add(stud.displayName)
                    }
                }
            }
        }
    }
    if (list.isEmpty()) {
        return ""
    }
    val leadingText = sendVM.leadingText
    when (sendVM.format) {
        SendFormat.INLINE -> {
            val listText = list.joinToString(", ")
            return if (leadingText.isNotEmpty()) {
                "$leadingText: $listText"
            } else {
                listText
            }
        }
        SendFormat.SEPARATE -> {
            val listText = "- " + list.joinToString("\n- ")
            return if (leadingText.isNotEmpty()) {
                "$leadingText:\n$listText"
            } else {
                listText
            }
        }
    }
}

@Composable
private fun SendFormattedText() {
    var text = buildSendText()
    var sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    var shareIntent = Intent.createChooser(sendIntent, null)
    LocalContext.current.startActivity(shareIntent)
}



























