package com.uolimzhanov.eshopeffectivemobile.ui.screens

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.ui.navigation.NavGraph
import com.uolimzhanov.eshopeffectivemobile.ui.navigation.Screen
import com.uolimzhanov.eshopeffectivemobile.ui.navigation.mainNavGraph
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 06.02.2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer(){
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: Screen.Login.route
    val screens = listOf(
        Screen.Login,
        Screen.Home,
        Screen.Catalog,
        Screen.ItemScreen,
        Screen.Bag,
        Screen.Discounts,
        Screen.Account,
    )
    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(
                            id = screens.firstOrNull{
                                it.route == selectedDestination
                            }?.titleId ?: R.string.empty
                        )
                    )
                },
                navigationIcon = {
                    if(selectedDestination == Screen.ItemScreen.route){
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(painter = painterResource(id = R.drawable.left_arrow), contentDescription = null)
                        }
                    }
                },
                actions = {
                    if(selectedDestination == Screen.ItemScreen.route){
                        IconButton(onClick = {  }) {
                            Icon(painter = painterResource(id = R.drawable.send), contentDescription = null)
                        }
                    }
                }
            )
        },
        bottomBar = {
            if(navController.currentDestination?.route != Screen.Login.route) {
                BottomAppBar(
                    modifier = Modifier,
                    containerColor = Color.White,
                    contentColor = Color.White,
                    tonalElevation = 0.dp
                ) {
                    screens
                        .filter{it.route != Screen.Login.route && it.route != Screen.ItemScreen.route}
                        .forEach { screen ->
                            NavigationBarItem(
                                selected = selectedDestination == screen.route,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(painterResource(id = screen.iconId), contentDescription = screen.route)
                                },
                                label = {
                                    Text(
                                        text = stringResource(id = screen.titleId)
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Pink,
                                    selectedTextColor = Pink
                                )
                            )
                        }
                }
            }
        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = NavGraph.Catalog.route){
            mainNavGraph(
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }
}