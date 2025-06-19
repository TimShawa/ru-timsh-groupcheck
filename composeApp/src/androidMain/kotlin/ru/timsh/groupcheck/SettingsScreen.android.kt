package ru.timsh.groupcheck

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.MoreVert
import ru.timsh.groupcheck.ui.icons.SettingsFILL
import ru.timsh.groupcheck.ui.themes.Themes
import ru.timsh.groupcheck.ui.themes.apptheme.AppTheme

@ExperimentalMaterial3Api
@Preview
@Composable
fun SettingsScreenPreview() {
    Themes.AppTheme {
        Scaffold(
            modifier = Modifier.size(1080.dp, 2392.dp),
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(AppIcons.SettingsFILL, null) },
                        label = { Text("Settings", fontSize = 12.sp, fontWeight = FontWeight(700)) }
                    )
                }
            }
        ) { innerPadding ->
            SettingsScreen(
                modifier = Modifier
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}