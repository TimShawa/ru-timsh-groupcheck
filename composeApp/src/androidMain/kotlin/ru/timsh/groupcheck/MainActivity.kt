@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package ru.timsh.groupcheck

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import ru.timsh.groupcheck.database.getJournalDB
import ru.timsh.groupcheck.database.getSettingsDB
import ru.timsh.groupcheck.database.journalDB
import ru.timsh.groupcheck.database.settingsDB

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            activity = this

            journalDB = getJournalDB(applicationContext)
            settingsDB = getSettingsDB(applicationContext)

            App()
        }
    }
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