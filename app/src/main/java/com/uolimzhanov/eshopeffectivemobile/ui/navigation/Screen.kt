package com.uolimzhanov.eshopeffectivemobile.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.uolimzhanov.eshopeffectivemobile.R

/**
 * created by uolimzhanov on 05.02.2024
 */
sealed class Screen(val route: String, @StringRes val titleId: Int, @DrawableRes val iconId: Int){
    data object Login: Screen("login", R.string.login, R.drawable.account)
    data object Home: Screen("home", R.string.home, R.drawable.home)
    data object Catalog: Screen("catalog", R.string.catalog, R.drawable.catalog)
    data object ItemScreen: Screen("item_screen", R.string.empty, R.drawable.catalog)
    data object Bag: Screen("bag", R.string.cart, R.drawable.bag)
    data object Discounts: Screen("discounts", R.string.discounts, R.drawable.discount)
    data object Account: Screen("account", R.string.account, R.drawable.account)
}

sealed class NavGraph(val route: String) {
    data object Login : NavGraph("loginGraph")
    data object Catalog : NavGraph("catalogGraph")
}