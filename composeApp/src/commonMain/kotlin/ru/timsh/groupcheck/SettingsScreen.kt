@file:OptIn(ExperimentalMaterial3Api::class)

package ru.timsh.groupcheck

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.timsh.groupcheck.database.Setting
import ru.timsh.groupcheck.database.TypeConvertersClass
import ru.timsh.groupcheck.database.settingsDAO
import ru.timsh.groupcheck.database.settingsDB


@Composable
fun SettingsScreen(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        SettingsSearchBar()
        SettingsFeed()
    }
}


@Composable
fun SettingsSearchBar() {
    Box(Modifier.fillMaxWidth()) {
        SearchBar(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp, 8.dp),
            inputField = {
                SearchBarDefaults.InputField(
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    expanded = false,
                    onExpandedChange = {},
                    placeholder = { Text("Search") }
                )
            },
            expanded = false,
            onExpandedChange = {}
        ) {}
    }
}


@Composable
fun SettingsFeed() {
    var created by remember { mutableStateOf(false) }
    if (!created) {
        created = true
        val scope = rememberCoroutineScope()
        scope.launch {
            settingsDAO.upsert(
                Setting(
                    setting = "test.test_checkbox_setting"
                )
            )
            settingsDAO.setValueBoolean("test.test_checkbox_setting", true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CheckboxSetting(
            setting = "test.test_checkbox_setting",
            headline = "Test checkbox",
            supportingText = "Used only for testing purposes"
        )
    }
}


@Composable
fun CheckboxSetting(
    setting: String,
    headline: String,
    leadingContent: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    immediate: Boolean = true,
) {
    val checked: Boolean? by settingsDAO.selectValueBoolean(setting)
        .collectAsState(false)
    val scope = rememberCoroutineScope()
    val interactionSource = MutableInteractionSource()

    ListItem(
        headlineContent = {
            Text(headline)
        },
        leadingContent = leadingContent,
        supportingContent = supportingText?.let {
            {
                Text(it)
            }
        },
        trailingContent = {
            if (immediate) {
                Switch(
                    checked = checked == true,
                    interactionSource = interactionSource,
                    onCheckedChange = {
                        scope.launch {
                            settingsDAO.setValueBoolean(setting, checked != true)
                        }
                    }
                )
            } else {
                Checkbox(
                    checked = checked == true,
                    interactionSource = interactionSource,
                    onCheckedChange = {
                        scope.launch {
                            settingsDAO.setValueBoolean(setting, checked != true)
                        }
                    }
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = checked == true,
                onValueChange = {
                    scope.launch {
                        settingsDAO.setValueBoolean(setting, checked != true)
                    }
                },
                interactionSource = interactionSource,
                indication = LocalIndication.current
            )
    )
}




















