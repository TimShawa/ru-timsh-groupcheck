@file:OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)

package ru.timsh.groupcheck

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.ViewModel
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.rounded.Edit
import ru.timsh.groupcheck.ui.icons.rounded.EditGroupList
import ru.timsh.groupcheck.ui.icons.rounded.Info
import ru.timsh.groupcheck.ui.icons.rounded.MoreVert
import ru.timsh.groupcheck.ui.icons.rounded.Open
import ru.timsh.groupcheck.ui.icons.rounded.Paste
import ru.timsh.groupcheck.ui.icons.rounded.ResetListToDefault
import ru.timsh.groupcheck.ui.icons.rounded.Share
import ru.timsh.groupcheck.ui.icons.rounded.StatusLate
import ru.timsh.groupcheck.ui.icons.rounded.StatusMissed
import ru.timsh.groupcheck.ui.icons.rounded.StatusReasonable
import ru.timsh.groupcheck.ui.icons.rounded.StatusVisited
import ru.timsh.groupcheck.ui.icons.rounded.XAccountCircle
import ru.timsh.groupcheck.ui.icons.rounded.XSchool_96dp
import ru.timsh.groupcheck.ui.icons.rounded.XStatusLate
import ru.timsh.groupcheck.ui.icons.rounded.XStatusMissed
import ru.timsh.groupcheck.ui.icons.rounded.XStatusReasonable
import ru.timsh.groupcheck.ui.icons.rounded.XStatusVisited


//region Composables


@Composable
fun SharedTransitionScope.MainPage(
    sharedAVS: AnimatedVisibilityScope
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollBehavior = remember { topAppBarScrollBehavior }
    mainPageVM.moreActionsSheetState = rememberModalBottomSheetState()

    Scaffold(
        topBar = {
            MainPageTopBar({ scrollBehavior }, { mainPageVM.isMoreActionsVisible = true })
        },
        floatingActionButton = {
            MainPageFAB(
                onClick = {
                    appVM.navController!!.navigate(Pages.SEND)
                },
                animVisScope = sharedAVS
            )
        },
        modifier = Modifier
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Crossfade(appVM.studList.isEmpty()) { isEmpty ->
            if (isEmpty) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(innerPadding)
                        .consumeWindowInsets(innerPadding)
                        .fillMaxSize()
                ) {
                    var actionOpenFile by remember { mutableStateOf(false) }
                    var actionPasteList by remember { mutableStateOf(false) }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(56.dp, 0.dp)
                    ) {
                        Icon(
                            imageVector = AppIcons.Rounded.XSchool_96dp,
                            contentDescription = null,
                            modifier = Modifier.size(192.dp),
                            tint = MaterialTheme.colorScheme.surfaceVariant
                        )
                        Text(stringResource(R.string.empty_list_headline), style = MaterialTheme.typography.headlineMedium)
                        VSpacer(8.dp)
                        Text(
                            stringResource(R.string.empty_list_supporting_text),
                            color = MaterialTheme.colorScheme.outline
                        )
                        VSpacer(24.dp)
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FilledTonalIconButton(
                                enabled = false,
                                modifier = Modifier.height(40.dp),
                                onClick = {
                                    actionOpenFile = true
                                }
                            ) {
                                Icon(AppIcons.Rounded.Open, null)
                            }
                            HSpacer(8.dp)
                            Button(
                                onClick = {
                                    appVM.navController!!.navigate(Pages.EDIT_LIST)
                                },
                                contentPadding = PaddingValues(16.dp, 0.dp, 24.dp)
                            ) {
                                Icon(AppIcons.Rounded.Edit, null)
                                HSpacer(8.dp)
                                Text(stringResource(R.string.empty_list_button_edit_manually))
                            }
                            HSpacer(8.dp)
                            FilledTonalIconButton(
                                modifier = Modifier.height(40.dp),
                                onClick = {
                                    actionPasteList = true
                                }
                            ) {
                                Icon(AppIcons.Rounded.Paste, null)
                            }
                        }
                    }

                    if (actionOpenFile) {
                        val openIntent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                            addCategory(Intent.CATEGORY_OPENABLE)
                            type = "text/plain"
                        }
                        appVM.appContext!!.startActivity(openIntent)
                        actionOpenFile = false
                    }

                    if (actionPasteList) {
                        val clipboard = LocalClipboardManager.current
                        val text = clipboard.getText()?.text
                        if (text != null) {
                            studJournal = text
                            saveStudList()
                            refreshStudList()
                        }
                        actionPasteList = false
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .consumeWindowInsets(innerPadding)
                        .verticalScroll(mainPageVM.pageScrollState)
                ) {
                    for (index in 0..appVM.studList.lastIndex) {
                        MainPageListItem(index)
                    }
                    VSpacer(8.dp)
                }
            }
        }
    }

    if (mainPageVM.showStatusResetAlert) {
        StatusResetAlert(
            onConfirm = {
                mainPageVM.showStatusResetAlert = false
                appVM.navController!!.navigate(Pages.EDIT_LIST)
            },
            onDismissRequest = {
                mainPageVM.showStatusResetAlert = false
            }
        )
    }
}


@Composable
private fun SharedTransitionScope.MainPageFAB(
    onClick: () -> Unit,
    animVisScope: AnimatedVisibilityScope,
) {
    AnimatedVisibility(
        visible = !appVM.studList.isEmpty(),
        enter = scaleIn(tween(200), 0f, TransformOrigin(1f, 1f)),
        exit = scaleOut(tween(200), 0f, TransformOrigin(1f, 1f))
    ) {
        FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            onClick = onClick,
            modifier = Modifier
                .sharedBounds(
                    rememberSharedContentState("FAB_EXPLODE_SHARE"),
                    animVisScope
                )
        ) {
            Icon(
                AppIcons.Rounded.Share, null, modifier = Modifier
                    .size(24.dp)
                    .aspectRatio(1f)
            )
        }
    }
}


@Composable
private fun MainPageTopBar(getScrollBehavior: () -> TopAppBarScrollBehavior, onMoreClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        actions = {
            Crossfade(appVM.studList.isNotEmpty()) { isNotEmpty ->
                if (isNotEmpty) {
                    IconButton(
                        onClick = onMoreClicked,
                    ) {
                        Icon(AppIcons.Rounded.MoreVert, null)
                    }
                    LaunchedEffect(mainPageVM.isMoreActionsVisible) {
                        if (mainPageVM.isMoreActionsVisible) {
                            mainPageVM.moreActionsSheetState?.show()
                        }
                    }
                    if (mainPageVM.moreActionsSheetState!!.currentValue != SheetValue.Hidden) {
                        MoreActionsSheet { hideSheet ->
                            mainPageVM.isMoreActionsVisible = false
                            hideSheet.value = true
                        }
                    }
//                    MoreActionsMenu {
//                        mainPageVM.isMoreActionsVisible = false
//                    }
                }
            }
        },
        scrollBehavior = getScrollBehavior()
    )
}


@Composable
private fun MainPageListItem(index: Int) {
    val student: StudEntry = remember { appVM.studList[index] }
    var isStatusDialogOpen by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    ListItem(
        leadingContent = {
            Icon(
                imageVector = AppIcons.Rounded.XAccountCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(32.dp)
            )
        },
        headlineContent = {
            Text(
                student.displayName,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp, 0.dp),
                overflow = TextOverflow.Ellipsis
            )
        },
        trailingContent = {
            StatusButton(
                index = index,
                onClick = { isStatusDialogOpen = true }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
    if (isStatusDialogOpen) {
        StatusButtonDialog(
            index = index,
            onDismissRequest = { isStatusDialogOpen = false }
        )
    }
}


@Composable
private fun StatusButton(index: Int, onClick: () -> Unit) {
    val status = appVM.studList[index].status
    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(24.dp, 0.dp, 16.dp, 0.dp),
        modifier = Modifier.height(36.dp)
    ) {
        Text(
            stringResource(
                when (status) {
                    StudStatus.VISITED -> R.string.status_visited_list
                    StudStatus.LATE -> R.string.status_late_stud_list
                    StudStatus.MISSED -> R.string.status_missed_stud_list
                    StudStatus.REASONABLE -> R.string.status_reasonable_stud_list
                }
            )
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            contentDescription = null,
            imageVector = when (status) {
                StudStatus.VISITED -> AppIcons.Rounded.XStatusVisited
                StudStatus.LATE -> AppIcons.Rounded.StatusLate
                StudStatus.MISSED -> AppIcons.Rounded.XStatusMissed
                StudStatus.REASONABLE -> AppIcons.Rounded.StatusReasonable
            },
            tint = when (status) {
                StudStatus.VISITED -> MaterialTheme.colorScheme.primary
                StudStatus.LATE -> MaterialTheme.colorScheme.primary
                StudStatus.MISSED -> MaterialTheme.colorScheme.error
                StudStatus.REASONABLE -> MaterialTheme.colorScheme.tertiary
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StatusButtonDialog(index: Int, onDismissRequest: () -> Unit) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.widthIn(280.dp, 560.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = stringResource(R.string.change_status_title)
                        .replace("{student}", appVM.studList[index].displayName),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(Modifier.height(16.dp))
                var selectedStatus by rememberSaveable {
                    mutableStateOf<StudStatus>(appVM.studList[index].status)
                }
                Column(
                    Modifier.fillMaxWidth()
                ) {
                    for (it in StudStatus.entries) {
                        val text = stringResource(when (it) {
                            StudStatus.VISITED -> R.string.status_visited_change_dialog
                            StudStatus.LATE -> R.string.status_late_change
                            StudStatus.MISSED -> R.string.status_missed_change_dialog
                            StudStatus.REASONABLE -> R.string.status_reasonable_change_dialog
                        })
                        ListItem(
                            leadingContent = {
                                Crossfade(
                                    it == selectedStatus,
                                    animationSpec = tween(200)
                                ) { selected ->
                                    Crossfade(it) { itemStatus ->
                                        Icon(
                                            imageVector = if (selected) {
                                                when (itemStatus) {
                                                    StudStatus.VISITED -> AppIcons.Rounded.XStatusVisited
                                                    StudStatus.LATE -> AppIcons.Rounded.XStatusLate
                                                    StudStatus.MISSED -> AppIcons.Rounded.XStatusMissed
                                                    StudStatus.REASONABLE -> AppIcons.Rounded.XStatusReasonable
                                                }
                                            } else {
                                                when (itemStatus) {
                                                    StudStatus.VISITED -> AppIcons.Rounded.StatusVisited
                                                    StudStatus.LATE -> AppIcons.Rounded.StatusLate
                                                    StudStatus.MISSED -> AppIcons.Rounded.StatusMissed
                                                    StudStatus.REASONABLE -> AppIcons.Rounded.StatusReasonable
                                                }
                                            },
                                            contentDescription = null,
                                            tint = if (selected) {
                                                MaterialTheme.colorScheme.primary
                                            } else {
                                                MaterialTheme.colorScheme.onSurface
                                            }
                                        )
                                    }
                                }
                            },
                            headlineContent = {
                                Text(text)
                            },
                            modifier = Modifier.clickable(
                                onClick = {
                                    appVM.studList[index].status = it
                                    onDismissRequest()
                                },
                                interactionSource = null,
                                indication = LocalIndication.current
                            )
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun MoreActionsMenu(
    onDismissRequest: () -> Unit
) {
    DropdownMenu(
        offset = DpOffset(0.dp, 8.dp),
        expanded = mainPageVM.isMoreActionsVisible,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.main_more_reset_marks))
            },
            onClick = {
                resetStudList()
                onDismissRequest()
            },
            leadingIcon = {
                Icon(AppIcons.Rounded.ResetListToDefault, null)
            }
        )
        DropdownMenuItem(
//            enabled = false,
            text = {
                Text(stringResource(R.string.main_more_edit_list))
            },
            leadingIcon = {
                Icon(AppIcons.Rounded.EditGroupList, null)
            },
            onClick = {
                onDismissRequest()
                mainPageVM.showStatusResetAlert = true
            }
        )
    }
}


@Composable
private fun MoreActionsSheet(
    onDismissRequest: (MutableState<Boolean>) -> Unit
) {
    var hideSheet = remember { mutableStateOf(false) }
    ModalBottomSheet(
        sheetState = mainPageVM.moreActionsSheetState!!,
        containerColor = MaterialTheme.colorScheme.surface,
        onDismissRequest = { onDismissRequest(hideSheet) }
    ) {
        ListItem(
            leadingContent = {
                Icon(AppIcons.Rounded.ResetListToDefault, null)
            },
            headlineContent = {
                Text(stringResource(R.string.main_more_reset_marks))
            },
            modifier = Modifier.clickable(
                onClick = {
                    resetStudList()
                    onDismissRequest(hideSheet)
                }
            )
        )
        // "Edit group list" item
        ListItem(
            leadingContent = {
                Icon(AppIcons.Rounded.EditGroupList, null)
            },
            headlineContent = {
                Text(stringResource(R.string.main_more_edit_list))
            },
            modifier = Modifier
                .clickable(
                    onClick = {
                        onDismissRequest(hideSheet)
                        if (checkIfChanged()) {
                            mainPageVM.showStatusResetAlert = true
                        } else {
                            appVM.navController!!.navigate(Pages.EDIT_LIST)
                        }
                    }
                )
        )
    }
    if (hideSheet.value) {
        LaunchedEffect(null) {
            mainPageVM.moreActionsSheetState?.hide()
            hideSheet.value = false
        }
    }
}


@Composable
private fun StatusResetAlert(onConfirm: () -> Unit, onDismissRequest: () -> Unit) {
    BasicAlertDialog(
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        ),
        onDismissRequest = onDismissRequest
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            modifier = Modifier.widthIn(280.dp, 560.dp)
        ) {
            Column(
                Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = AppIcons.Rounded.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
                VSpacer(16.dp)
                Text(
                    text = stringResource(R.string.stat_res_alert_title),
                    style = MaterialTheme.typography.headlineSmall
                )
                VSpacer(16.dp)
                Text(
                    text = stringResource(R.string.stat_res_alert_text),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                VSpacer(24.dp)
                Row(
                    Modifier.height(40.dp),
                ) {
                    HSpacer(0.dp, true)
                    TextButton(
                        onClick = onDismissRequest
                    ) {
                        Text(stringResource(R.string.button_cancel))
                    }
                    HSpacer(8.dp)
                    TextButton(
                        onClick = onConfirm
                    ) {
                        Text(stringResource(R.string.button_continue))
                    }
                }
            }
        }
    }
}


//endregion


class StudEntry {
    var displayName: String = ""
    var status: StudStatus by mutableStateOf(StudStatus.VISITED)
}

enum class StudStatus {
    VISITED,
    LATE,
    MISSED,
    REASONABLE
}


class MainPageVM: ViewModel() {
    var pageScrollState = ScrollState(0)
    var isMoreActionsVisible by mutableStateOf(false)
    var moreActionsSheetState: SheetState? = null
    var showStatusResetAlert by mutableStateOf(false)
}

var mainPageVM = MainPageVM()

































