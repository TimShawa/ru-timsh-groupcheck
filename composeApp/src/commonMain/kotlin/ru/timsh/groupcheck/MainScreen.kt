@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)

package ru.timsh.groupcheck

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import ru.timsh.groupcheck.ui.icons.AppIcons
import ru.timsh.groupcheck.ui.icons.Groups
import ru.timsh.groupcheck.ui.icons.GroupsFill
import ru.timsh.groupcheck.ui.icons.History
import ru.timsh.groupcheck.ui.icons.Menu
import ru.timsh.groupcheck.ui.icons.MoreVert
import ru.timsh.groupcheck.ui.icons.Settings
import ru.timsh.groupcheck.ui.icons.SettingsFILL
import ru.timsh.groupcheck.ui.icons.Today
import ru.timsh.groupcheck.ui.icons.TodayFILL


@Composable
fun MainScreen(sizeClass: WindowWidthSizeClass) {
    mainPageVM.drawerState = rememberDrawerState(DrawerValue.Closed)
    val topBarScroll = TopAppBarDefaults.pinnedScrollBehavior()

    AdaptiveNavigationDrawer(
        sizeClass = sizeClass,
        drawerState = mainPageVM.drawerState ?: rememberDrawerState(DrawerValue.Closed)
    ) {
        Row(
            Modifier.fillMaxSize()
        ) {
            if (sizeClass != WindowWidthSizeClass.Compact) {
                MainScreenSideBar()
            }
            Scaffold(
                containerColor = if(sizeClass == WindowWidthSizeClass.Compact) {
                    MaterialTheme.colorScheme.surface
                } else {
                    MaterialTheme.colorScheme.surfaceContainer
                },
                topBar = {
                    MainScreenTopBar(sizeClass, topBarScroll)
                },
                bottomBar = {
                    if (sizeClass == WindowWidthSizeClass.Compact) {
                        MainScreenNavBar()
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .nestedScroll(topBarScroll.nestedScrollConnection)
            ) { innerPadding ->
                when (sizeClass) {
                    WindowWidthSizeClass.Compact -> {
                        CompactPage(innerPadding)
                    }
                    WindowWidthSizeClass.Medium -> {
                        MediumPage(innerPadding)
                    }
                    WindowWidthSizeClass.Expanded -> {
                        ExpandedPage(innerPadding)
                    }
                }
            }
        }
    }
}


@Composable
fun CompactPage(innerPadding: PaddingValues) {
    DateSubjectsScreen(
        modifier = Modifier
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
    )
}


@Composable
fun MediumPage(innerPadding: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier = Modifier
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
                .padding(end = 16.dp)
        ) {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.weight(1f)
                    .fillMaxHeight()
            ) {}
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.weight(1f)
                    .fillMaxHeight()
            ) {}
        }
    }
}


@Composable
fun ExpandedPage(innerPadding: PaddingValues) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier = Modifier
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
                .padding(end = 16.dp)
        ) {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.weight(2.5f)
                    .fillMaxHeight()
            ) {}
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.weight(1f)
                    .fillMaxHeight()
            ) {}
        }
    }
}


@Composable
fun MainScreenTopBar(
    sizeClass: WindowWidthSizeClass,
    scrollBehavior: TopAppBarScrollBehavior?
) {
    var coroutineScope = rememberCoroutineScope()
    if (sizeClass == WindowWidthSizeClass.Compact) {
        CenterAlignedTopAppBar(
            scrollBehavior = scrollBehavior,
            title = {
                Text("Group Check", modifier = Modifier.fillMaxWidth())
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            mainPageVM.drawerState?.open()
                        }
                    }
                ) {
                    Icon(AppIcons.Menu, null)
                }
            },
            actions = {
                IconButton(
                    enabled = false,
                    onClick = {}
                ) {
                    Icon(AppIcons.MoreVert, null)
                }
            }
        )
    } else {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            ),
            title = {
                Text("Group Check")
            },
            actions = {
                IconButton(
                    enabled = false,
                    onClick = {}
                ) {
                    Icon(AppIcons.MoreVert, null)
                }
            }
        )
    }
}


@Composable
fun MainScreenSideBar() {
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        header = {
            val coroutineScope = rememberCoroutineScope()
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        mainPageVM.drawerState?.open()
                    }
                },
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(AppIcons.Menu, null)
            }
        }
    ) {
        NavRailItem(
            selected = true,
            onClick = {},
            data = NavBarItemData(AppIcons.TodayFILL, AppIcons.Today, "Today")
        )
        NavRailItem(
            selected = false,
            onClick = {},
            data = NavBarItemData(AppIcons.History, AppIcons.History, "History")
        )
        NavRailItem(
            selected = false,
            onClick = {},
            data = NavBarItemData(AppIcons.GroupsFill, AppIcons.Groups, "Group")
        )
        NavRailItem(
            selected = false,
            onClick = {},
            data = NavBarItemData(AppIcons.SettingsFILL, AppIcons.Settings, "Settings")
        )
    }
}


@Composable
fun MainScreenNavBar() {
    NavigationBar {
        var selectedTab by remember { mutableStateOf(0) }
        NavBarItem(
            selected = selectedTab == 0,
            onClick = { selectedTab = 0 },
            data = NavBarItemData(
                iconSelected = AppIcons.TodayFILL,
                iconUnselected = AppIcons.Today,
                labelText = "Today"
            )
        )
        NavBarItem(
            selected = selectedTab == 1,
            onClick = { selectedTab = 1 },
            data = NavBarItemData(
                iconSelected = AppIcons.History,
                iconUnselected = AppIcons.History,
                labelText = "History"
            )
        )
        NavBarItem(
            selected = selectedTab == 2,
            onClick = { selectedTab = 2 },
            data = NavBarItemData(
                iconSelected = AppIcons.GroupsFill,
                iconUnselected = AppIcons.Groups,
                labelText = "Group"
            )
        )
        NavBarItem(
            selected = selectedTab == 3,
            onClick = { selectedTab = 3 },
            data = NavBarItemData(
                iconSelected = AppIcons.SettingsFILL,
                iconUnselected = AppIcons.Settings,
                labelText = "Settings"
            )
        )
    }
}


data class NavBarItemData(
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val labelText: String
)


@Composable
fun RowScope.NavBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    data: NavBarItemData
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(if (selected) data.iconSelected else data.iconUnselected, null)
        },
        label = {
            Text(
                text = data.labelText,
                style = if (selected) {
                    LocalTextStyle.current.copy(fontWeight = FontWeight(700))
                } else {
                    LocalTextStyle.current
                }
            )
        }
    )
}


@Composable
fun ColumnScope.NavRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    data: NavBarItemData
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = if (selected) data.iconSelected else data.iconUnselected,
                contentDescription = null
            )
        },
        label = {
            Text(
                text = data.labelText,
                style = if (selected) {
                    LocalTextStyle.current.copy(fontWeight = FontWeight(700))
                } else {
                    LocalTextStyle.current
                }
            )
        }
    )
}


@Composable
fun AdaptiveNavigationDrawer(
    sizeClass: WindowWidthSizeClass,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    content: @Composable () -> Unit
) {
    when (sizeClass) {
        WindowWidthSizeClass.Compact -> {
            MainScreenCompactDrawer(drawerState, content)
        }
        WindowWidthSizeClass.Medium -> {
            MainScreenMediumDrawer(drawerState, content)
        }
        WindowWidthSizeClass.Expanded -> {
            MainScreenMediumDrawer(drawerState, content)
//            MainScreenExpandedDrawer(drawerState, content)
        }
    }
}


@Composable
fun MainScreenCompactDrawer(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        content = content,
        drawerContent = {
            ModalDrawerSheet(
                drawerState = drawerState
            ) {

            }
        }
    )
}


@Composable
fun MainScreenMediumDrawer(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        gesturesEnabled = mainPageVM.drawerState?.isOpen != false,
        drawerState = drawerState,
        content = content,
        drawerContent = {
            ModalDrawerSheet(
                drawerState = drawerState
            ) {
                Column(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .padding(14.dp, 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(336.dp, 64.dp)
                    ) {
                        val coroutineScope = rememberCoroutineScope()
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    mainPageVM.drawerState?.close()
                                }
                            },
                            modifier = Modifier.padding(4.dp, 0.dp)
                        ) {
                            Icon(AppIcons.Menu, null)
                        }
                    }

                    NavigationDrawerItem(
                        selected = true,
                        onClick = {},
                        label = { Text("Today") },
                        icon = { Icon(AppIcons.Today, null) }
                    )
                    NavigationDrawerItem(
                        selected = false,
                        onClick = {},
                        label = { Text("History") },
                        icon = { Icon(AppIcons.History, null) }
                    )
                    NavigationDrawerItem(
                        selected = false,
                        onClick = {},
                        label = { Text("Group") },
                        icon = { Icon(AppIcons.Groups, null) }
                    )
                    NavigationDrawerItem(
                        selected = false,
                        onClick = {},
                        label = { Text("Settings") },
                        icon = { Icon(AppIcons.Settings, null) }
                    )
                }
            }
        }
    )
}


@Composable
fun MainScreenExpandedDrawer(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        AnimatedContent(
            targetState = drawerState.targetValue,
            transitionSpec = {
                if (targetState == DrawerValue.Open) {
                    expandHorizontally(expandFrom = Alignment.Start) togetherWith
                            fadeOut()
                } else {
                    fadeIn() togetherWith
                            shrinkHorizontally(shrinkTowards = Alignment.Start)
                }
            }
        ) { targetState ->
            if (targetState == DrawerValue.Open) {
                DismissibleNavigationDrawer(
                    gesturesEnabled = false,
                    drawerState = drawerState,
                    content = content,
                    drawerContent = {
                        DismissibleDrawerSheet(
                            drawerContainerColor = MaterialTheme.colorScheme.surfaceContainer
                        ) {
                            Column(
                                modifier = Modifier
                                    .safeDrawingPadding()
                                    .padding(14.dp, 8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(336.dp, 64.dp)
                                ) {
                                    val coroutineScope = rememberCoroutineScope()
                                    IconButton(
                                        onClick = {
                                            coroutineScope.launch {
                                                mainPageVM.drawerState?.close()
                                            }
                                        },
                                        modifier = Modifier.padding(4.dp, 0.dp)
                                    ) {
                                        Icon(AppIcons.Menu, null)
                                    }
                                }

                                NavigationDrawerItem(
                                    selected = true,
                                    onClick = {},
                                    label = { Text("Today") },
                                    icon = { Icon(AppIcons.Today, null) }
                                )
                                NavigationDrawerItem(
                                    selected = false,
                                    onClick = {},
                                    label = { Text("History") },
                                    icon = { Icon(AppIcons.History, null) }
                                )
                                NavigationDrawerItem(
                                    selected = false,
                                    onClick = {},
                                    label = { Text("Group") },
                                    icon = { Icon(AppIcons.Groups, null) }
                                )
                                NavigationDrawerItem(
                                    selected = false,
                                    onClick = {},
                                    label = { Text("Settings") },
                                    icon = { Icon(AppIcons.Settings, null) }
                                )
                            }
                        }
                    }
                )
            } else {
                MainScreenSideBar()
            }
        }
    }
}


class MainPageViewModel: ViewModel() {
    var drawerState: DrawerState? = null
}


var mainPageVM = MainPageViewModel()














