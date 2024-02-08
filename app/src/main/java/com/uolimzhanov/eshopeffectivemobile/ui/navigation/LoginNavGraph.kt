package com.uolimzhanov.eshopeffectivemobile.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
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
        val viewModel = it.sharedViewModel<LoginViewModel>(navController = navController)
        val loginState by viewModel.loginState.collectAsStateWithLifecycle()
        val isFirstNameValid by remember {
            derivedStateOf {
                loginState.firstName.isCyrillic()
            }
        }
        val isLastNameValid by remember {
            derivedStateOf {
                loginState.lastName.isCyrillic()
            }
        }
        LoginScreen(
            modifier = Modifier
                .padding(paddingValues)
                .statusBarsPadding()
                .navigationBarsPadding(),
            state = loginState,
            onFirstNameChanged = { firstName ->
                viewModel.onEvent(LoginUiEvent.FirstNameChanged(firstName))
            },
            onLastNameChanged = { lastName ->
                viewModel.onEvent(LoginUiEvent.LastNameChanged(lastName))
            },
            onPhoneNumberChanged = { phoneNumber ->
                viewModel.onEvent(LoginUiEvent.PhoneNumberChanged(phoneNumber))
            },
            onLoginClick = {
                viewModel.onEvent(LoginUiEvent.LogIn)
                //if (loginState.wasLoggedIn){
                    navController.navigate(Screen.Catalog.route)
                //} else navController.navigate(Screen.Home.route)
            },
            onClearFirstName = { viewModel.onEvent(LoginUiEvent.ClearFirstName) },
            onClearLastName = { viewModel.onEvent(LoginUiEvent.ClearLastName) },
            onClearPhoneNumber = { viewModel.onEvent(LoginUiEvent.ClearPhoneNumber) },
            isLastNameValid = isLastNameValid,
            isFirstNameValid = isFirstNameValid
        )
    }
}
