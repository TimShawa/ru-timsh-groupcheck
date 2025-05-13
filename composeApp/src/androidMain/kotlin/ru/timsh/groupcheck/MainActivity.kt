@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package ru.timsh.groupcheck

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.window.OnBackInvokedCallback
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            activity = this
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}


@SuppressLint("StaticFieldLeak")
var activity: Activity? = null


@Composable
actual fun getSizeClass(): WindowWidthSizeClass {
    return if (activity != null) {
        calculateWindowSizeClass(activity!!).widthSizeClass
    } else {
        WindowWidthSizeClass.Compact
    }
}