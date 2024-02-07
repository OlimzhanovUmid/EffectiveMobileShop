package com.uolimzhanov.eshopeffectivemobile.ui.screens.login

/**
 * created by uolimzhanov on 06.02.2024
 */

sealed class LoginUiEvent {
    data class FirstNameChanged(val value: String) : LoginUiEvent()
    data class LastNameChanged(val value: String) : LoginUiEvent()
    data class PhoneNumberChanged(val value: String) : LoginUiEvent()
    data object ClearFirstName: LoginUiEvent()
    data object ClearLastName: LoginUiEvent()
    data object ClearPhoneNumber: LoginUiEvent()
    data object LogIn : LoginUiEvent()
}
