@file:OptIn(ExperimentalSharedTransitionApi::class)

package ru.timsh.groupcheck

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.timsh.groupcheck.ui.theme.GroupCheckTheme
import java.io.File
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            var studListLoaded by remember { mutableStateOf(false) }
            appVM.navController = rememberNavController()
            appVM.appContext = applicationContext
            if (appVM.studList.isEmpty()) {
                loadStudList()
            }
            GroupCheckTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    SharedTransitionLayout {
                        NavHost(
                            navController = appVM.navController!!,
                            startDestination = Pages.MAIN
                        ) {
                            composable(
                                route = Pages.MAIN,
                                enterTransition = {
                                    when (initialState.destination.route) {
                                        Pages.EDIT_LIST -> {
                                            slideInHorizontally { -it / 2 }
                                        }

                                        else -> {
                                            fadeIn()
                                        }
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        Pages.EDIT_LIST -> {
                                            slideOutHorizontally { -it / 2 } +
                                                    fadeOut()
                                        }

                                        else -> {
                                            fadeOut()
                                        }
                                    }
                                }
                            ) {
                                MainPage(this)
                            }
                            composable(
                                route = Pages.SEND
                            ) {
                                SendPage(this)
                            }
                            composable(
                                route = Pages.EDIT_LIST,
                                enterTransition = {
                                    slideInHorizontally { it / 2 } +
                                            fadeIn()
                                },
                                exitTransition = {
                                    slideOutHorizontally { it / 2 } +
                                            fadeOut()
                                }
                            ) {
                                EditListPage()
                            }
                        }
                    }
                }
            }
        }
    }
}


var appVM: AppViewModel = AppViewModel()


class AppViewModel: ViewModel() {
    var appContext: Context? = null
    var studList = mutableStateListOf<StudEntry>()
    var navController: NavHostController? = null
}

object Pages {
    const val MAIN = "main_page"
    const val SEND = "send_page"
    const val EDIT_LIST = "edit_list_page"
}

fun refreshStudList() {
    appVM.studList.clear()
    for (it in newStudList()) {
        appVM.studList.add(it)
    }
}

fun resetStudList() {
    for (it in appVM.studList) {
        it.status = StudStatus.VISITED
    }
}


fun saveStudList() {
    try {
        val file = File(appVM.appContext!!.filesDir, "stud_list.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        file.writer().apply {
            write(studJournal)
            close()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}


fun loadStudList() {
    try {
        val file = File(appVM.appContext!!.filesDir, "stud_list.txt")
        if (file.exists()) {
            file.reader().apply {
                studJournal = readText()
                close()
            }
            optimizeStudList()
            refreshStudList()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}


fun optimizeStudList() {
    val oldLines = studJournal.lines()
    val newLines = mutableListOf<String>()
    for (i in 0..oldLines.lastIndex) {
        val line = oldLines[i].trim()
        if (line != "") {
            newLines.add(line)
        }
    }
    studJournal = newLines.joinToString("\n")
}


fun newStudList(): List<StudEntry> {
    if (studJournal.trim() == "") {
        return listOf()
    }
    optimizeStudList()
    val list = mutableListOf<StudEntry>()
    val lines: List<String> = studJournal.split("\n")
    for (i in 0..lines.lastIndex) {
        list.add(
            StudEntry().apply {
                displayName = lines[i].trim()
                status = StudStatus.VISITED
            }
        )
    }
    return list
}


fun checkIfChanged(): Boolean {
    var changed = false
    for (it in appVM.studList) {
        if (it.status != StudStatus.VISITED) {
            changed = true
            break
        }
    }
    return changed
}

















