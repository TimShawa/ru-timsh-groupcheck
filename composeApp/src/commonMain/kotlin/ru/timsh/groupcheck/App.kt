package ru.timsh.groupcheck

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.timsh.groupcheck.ui.themes.Themes
import ru.timsh.groupcheck.ui.themes.apptheme.AppTheme

@Composable
@Preview
fun App() {
    Themes.AppTheme(dynamicColor = true) {
        var sizeClass = getSizeClass()
        MainScreen(sizeClass)
    }
}


@Composable
expect fun getSizeClass(): WindowWidthSizeClass
