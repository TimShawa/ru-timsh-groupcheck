package ru.timsh.groupcheck

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.timsh.groupcheck.database.Journal
import ru.timsh.groupcheck.database.JournalDB
import ru.timsh.groupcheck.database.Subjects
import ru.timsh.groupcheck.database.journalDAO
import ru.timsh.groupcheck.ui.themes.Themes
import ru.timsh.groupcheck.ui.themes.apptheme.AppTheme


@Composable
@Preview
fun App() {
    Themes.AppTheme(dynamicColor = true) {
        var created by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        if (!created) {
            created = true
            scope.launch {
                journalDAO.clearAll()
                journalDAO.clearAllSubjects()
                journalDAO.upsertSubject(
                    Subjects(
                        date = "18.06.2025",
                        dailyIndex = 0,
                        subjectName = "Networking",
                        beginTime = 830,
                        endTime = 1000
                    )
                )
                journalDAO.upsertSubject(
                    Subjects(
                        date = "18.06.2025",
                        dailyIndex = 1,
                        subjectName = "Networking",
                        beginTime = 1010,
                        endTime = 1140
                    )
                )
                journalDAO.upsertSubject(
                    Subjects(
                        date = "18.06.2025",
                        dailyIndex = 2,
                        subjectName = "Networking",
                        beginTime = 1200,
                        endTime = 1330
                    )
                )
                for (i in 1..25) {
                    journalDAO.upsert(
                        Journal(
                            date = "18.06.2025",
                            subject = 0,
                            student = "Student $i"
                        )
                    )
                }
                for (i in 1..25) {
                    journalDAO.upsert(
                        Journal(
                            date = "18.06.2025",
                            subject = 1,
                            student = "Student $i"
                        )
                    )
                }
                for (i in 1..25) {
                    journalDAO.upsert(
                        Journal(
                            date = "18.06.2025",
                            subject = 2,
                            student = "Student $i"
                        )
                    )
                }
            }
        }

        var sizeClass = getSizeClass()
        MainScreen(sizeClass)
    }
}


@Composable
expect fun getSizeClass(): WindowWidthSizeClass


class AppViewModel: ViewModel() {
    var navController: NavHostController? = null
}


val appVM = AppViewModel()

enum class Status