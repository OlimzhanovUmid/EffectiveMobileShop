package com.uolimzhanov.eshopeffectivemobile.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uolimzhanov.eshopeffectivemobile.ui.screens.account.AccountScreen
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
            var sortMenuExpanded by remember { mutableStateOf(false) }

            val viewModel = it.sharedViewModel<CatalogViewModel>(navController = navController)
            val catalogState by viewModel.catalogState.collectAsStateWithLifecycle()

            CatalogScreen(
                state = catalogState,
                paddingValues = paddingValues,
                isExpanded = sortMenuExpanded,
                onDismiss = { sortMenuExpanded = false},
                onSortOrderSelected = {
                    sortMenuExpanded = false
                },
                onExpandedChange = { sortMenuExpanded = !sortMenuExpanded },
                onSelectTag = { tag ->
                    viewModel.onEvent(CatalogUiEvent.SelectTag(tag))
                },
                onOpenClick = { item ->
                    viewModel.onEvent(CatalogUiEvent.OpenItem(item))
                    navController.navigate(Screen.ItemScreen.route)
                },
                onSaveItem = { item ->
                    viewModel.onEvent(CatalogUiEvent.SaveItem(item))
                }
            )
        }
        composable(
            route = Screen.ItemScreen.route,
        ){entry ->
            val viewModel = entry.sharedViewModel<CatalogViewModel>(navController = navController)
            val catalogState by viewModel.catalogState.collectAsState()
            var isDescriptionVisible by remember {
                mutableStateOf(true)
            }
            var areIngredientsVisible by remember {
                mutableStateOf(true)
            }
            ItemScreen(
                onDescriptionVisibilityChange = { isDescriptionVisible = !isDescriptionVisible },
                onIngredientsVisibilityChange = { areIngredientsVisible = !areIngredientsVisible },
                isDescriptionVisible = isDescriptionVisible,
                areIngredientsVisible = areIngredientsVisible,
                paddingValues = paddingValues,
                uiItem = catalogState.openedItem,
                onSaveClick = {
                    viewModel.onEvent(CatalogUiEvent.SaveItem(it))
                }
            )
        }
        composable(
            route = Screen.Account.route
        ){entry ->

            val viewModel = entry.sharedViewModel<CatalogViewModel>(navController = navController)
            val catalogState by viewModel.catalogState.collectAsState()
            AccountScreen(
                modifier = Modifier.padding(paddingValues),
                user = catalogState.currentUser,
                items = catalogState.items.filter { it.isLiked }
            )
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

}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}