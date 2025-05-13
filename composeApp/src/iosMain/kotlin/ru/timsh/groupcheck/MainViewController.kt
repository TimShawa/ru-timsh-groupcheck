@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package ru.timsh.groupcheck

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App() }


@Composable
actual fun getSizeClass(): WindowWidthSizeClass {
    return calculateWindowSizeClass().widthSizeClass
}