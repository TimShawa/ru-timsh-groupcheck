@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class,
    ExperimentalComposeUiApi::class
)

package ru.timsh.groupcheck

import android.content.ClipData
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.foundation.text.input.placeCursorAtEnd
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.selectAll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.substring
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.rounded.ArrowBack
import ru.timsh.groupcheck.ui.icons.rounded.CopyAll
import ru.timsh.groupcheck.ui.icons.rounded.LastPage
import ru.timsh.groupcheck.ui.icons.rounded.PersonRemove
import ru.timsh.groupcheck.ui.icons.rounded.Save
import ru.timsh.groupcheck.ui.icons.rounded.SelectAll


@Composable
fun EditListPage() {
    editListVM.clipboard = LocalClipboardManager.current
    editListVM.fieldState = rememberTextFieldState(studJournal)
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = { EditListTopBar(topAppBarScrollBehavior) },
        bottomBar = {
            EditListBottomBar()
        },
        modifier = Modifier
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
            .imePadding()
    ) {
        EditListPageBody(it)
    }
}


@Composable
private fun EditListTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(stringResource(R.string.edit_list_title), overflow = TextOverflow.Ellipsis, maxLines = 1)
        },
        navigationIcon = {
            IconButton(
                onClick = { appVM.navController!!.navigateUp() }
            ) {
                Icon(imageVector = AppIcons.Rounded.ArrowBack, null)
            }
        },
        actions = {

        }
    )
}


@Composable
private fun EditListBottomBar() {
    BottomAppBar(
        actions = {
            IconButton({
                editListVM.fieldState?.edit {
                    if (selection.length == length) {
                        placeCursorAtEnd()
                    } else {
                        selectAll()
                    }
                }
            }) {
                Icon(AppIcons.Rounded.SelectAll, null)
            }

            IconButton({
                editListVM.fieldState?.edit {
                    editListVM.clipboard!!.setClip(
                        ClipEntry(
                            if (hasSelection) {
                                ClipData.newPlainText(
                                    "Group list selection",
                                    originalText.substring(selection)
                                )
                            } else {
                                ClipData.newPlainText(
                                    "Group list",
                                    originalText
                                )
                            }
                        )
                    )
                }
            }) {
                Icon(AppIcons.Rounded.CopyAll, null)
            }

            IconButton({
                editListVM.fieldState?.edit {
                    placeCursorAtEnd()
                }
            }) {
                Icon(AppIcons.Rounded.LastPage, null)
            }

            IconButton({
                editListVM.fieldState?.edit {
                    if (!hasSelection) {
                        val cursorPos = selection.start
                        val startPos = originalText.slice(IntRange(0, cursorPos - 1)).indexOfLast { it == '\n' } + 1
                        val endPos = cursorPos + originalText.slice(IntRange(cursorPos, length - 1)).indexOfFirst { it == '\n' } + 1
                        delete(
                            start = if (startPos != -1) startPos else 0,
                            end = if (endPos != -1) endPos else length-1
                        )
                        var newPos = selection.start - 1
                        placeCursorBeforeCharAt(if (newPos < 0) 0 else newPos)
                    }
                }
            }) {
                Icon(AppIcons.Rounded.PersonRemove, null)
            }
        },

        floatingActionButton = {
            EditListFAB()
        }
    )
}


@Composable
private fun EditListFAB() {
    AnimatedVisibility(
        visible = (editListVM.fieldState!!.text != studJournal),
        enter = scaleIn(
            animationSpec = tween(200)
        ),
        exit = scaleOut(
            animationSpec = tween(200)
        )
    ) {
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.loweredElevation(),
            onClick = {
                studJournal = editListVM.fieldState!!.text.toString()
                saveStudList()
                refreshStudList()
                appVM.navController!!.navigate(Pages.MAIN)
            }
        ) {
            Icon(AppIcons.Rounded.Save, null)
        }
    }
}


@Composable
private fun EditListPageBody(innerPadding: PaddingValues) {
    BasicTextField(
        state = editListVM.fieldState!!,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant),
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
        modifier = Modifier
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
            .fillMaxSize()
            .focusProperties {
                left = FocusRequester.Cancel
                right = FocusRequester.Cancel
                up = FocusRequester.Cancel
                down = FocusRequester.Cancel
                next = FocusRequester.Default
                previous = FocusRequester.Default
            },
        decorator = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Box(
                        modifier = Modifier.padding(16.dp, 12.dp)
                    ) {
                        innerTextField()
                    }
                }
            }
        }
    )
}


private fun getLinesRowText(text: String): String {
    var rValue = ""
    var lastIndex = text.lines().lastIndex
    for (i in 0..lastIndex) {
        rValue += "$i"
        if (i != lastIndex) {
            rValue += "\n"
        }
    }
    return rValue
}


private class EditListModel: ViewModel() {
    var fieldState: TextFieldState? = null
    var clipboard: ClipboardManager? = null
}

private val editListVM = EditListModel()





















