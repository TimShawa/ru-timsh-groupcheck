package ru.timsh.groupcheck


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Nav {

    @Serializable object Today

    @Serializable class TodayScreen
    @Serializable class SubjectScreen
    @Serializable class MessageScreen


    @Serializable object History


    @Serializable object Group


    @Serializable object Settings

}


@Composable
fun Navigation(
    todayScreenContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},
    subjectScreenContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},
    messageScreenContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},

    historyContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},
    groupContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},
    settingsContent: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = {},
) {
    appVM.navController = rememberNavController()
    NavHost(
        navController = appVM.navController!!,
        startDestination = "today"
    ) {
        composable(
            route = "today",
            content = todayScreenContent,
            enterTransition = {
                fadeIn(tween(50))
            },
            exitTransition = {
                fadeOut(tween(50))
            }
        )
        composable(
            route = "settings",
            content = settingsContent,
            enterTransition = {
                fadeIn(tween(50))
            },
            exitTransition = {
                fadeOut(tween(50))
            }
        )

//        navigation<Nav.Today>(
//            startDestination = Nav.TodayScreen
//        ) {
//            composable<Nav.TodayScreen>(
//                content = todayScreenContent
//            )
//            composable<Nav.SubjectScreen>(
//                content = subjectScreenContent
//            )
//            composable<Nav.MessageScreen>(
//                content = messageScreenContent
//            )
//        }
//        composable<Nav.History>(
//            content = historyContent
//        )
//        composable<Nav.Group>(
//            content = groupContent
//        )
//        composable<Nav.Settings>(
//            content = settingsContent
//        )
    }
}
