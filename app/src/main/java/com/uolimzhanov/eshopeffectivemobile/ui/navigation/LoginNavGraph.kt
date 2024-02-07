package com.uolimzhanov.eshopeffectivemobile.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.uolimzhanov.eshopeffectivemobile.model.extensions.isCyrillic
import com.uolimzhanov.eshopeffectivemobile.ui.screens.login.LoginScreen
import com.uolimzhanov.eshopeffectivemobile.ui.screens.login.LoginUiEvent
import com.uolimzhanov.eshopeffectivemobile.ui.viewmodels.LoginViewModel

/**
 * created by uolimzhanov on 06.02.2024
 */
fun NavGraphBuilder.loginNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
){
    composable(
        route = Screen.Login.route
    ) {
    }
}
