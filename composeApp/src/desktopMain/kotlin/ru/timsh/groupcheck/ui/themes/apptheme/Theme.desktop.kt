package ru.timsh.groupcheck.ui.themes.apptheme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable


@Composable
actual fun getColorScheme(
    darkTheme: Boolean,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean,
    darkScheme: ColorScheme,
    lightScheme: ColorScheme
): ColorScheme {
    return if (darkTheme) {
        darkScheme
    } else {
        lightScheme
    }
}