@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package ru.timsh.groupcheck

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Group Check",
    ) {
        App()
    }
}


@Composable
actual fun getSizeClass(): WindowWidthSizeClass {
    return calculateWindowSizeClass().widthSizeClass
}