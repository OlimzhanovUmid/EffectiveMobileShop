package com.uolimzhanov.eshopeffectivemobile.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog.CatalogScreen
import com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog.CatalogUiEvent
import com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog.ItemScreen
import com.uolimzhanov.eshopeffectivemobile.ui.viewmodels.CatalogViewModel

/**
 * created by uolimzhanov on 05.02.2024
 */
fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
){
    navigation(
        startDestination = Screen.Login.route,
        route = NavGraph.Login.route
    ) {
       loginNavGraph(navController, paddingValues)
    }
    composable(
        route = Screen.Home.route
    ){

    }
    navigation(
        startDestination = Screen.Catalog.route,
        route = NavGraph.Catalog.route
    ){
        composable(
            route = Screen.Catalog.route
        ){
        }
        composable(
            route = Screen.ItemScreen.route,
        }
    }

    composable(
        route = Screen.Bag.route
    ){

    }
    composable(
        route = Screen.Discounts.route
    ){

    }
    composable(
        route = Screen.Account.route
    ){

    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}