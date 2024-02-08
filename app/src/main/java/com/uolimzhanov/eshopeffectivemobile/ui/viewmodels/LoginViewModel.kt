package com.uolimzhanov.eshopeffectivemobile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import com.uolimzhanov.eshopeffectivemobile.model.repository.UsersRepository
import com.uolimzhanov.eshopeffectivemobile.ui.screens.login.LoginState
import com.uolimzhanov.eshopeffectivemobile.ui.screens.login.LoginUiEvent
import com.uolimzhanov.eshopeffectivemobile.utils.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by uolimzhanov on 06.02.2024
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val usersRepo: UsersRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    fun onEvent(event: LoginUiEvent) {
        when(event){
            is LoginUiEvent.FirstNameChanged -> {
                _loginState.value = _loginState.value.copy(
                    firstName = event.value
                )
            }
            is LoginUiEvent.LastNameChanged -> {
                _loginState.value = _loginState.value.copy(
                    lastName = event.value
                )
            }
            is LoginUiEvent.PhoneNumberChanged -> {
                _loginState.value = _loginState.value.copy(
                    phoneNumber = event.value
                )
            }
            LoginUiEvent.LogIn -> {
                viewModelScope.launch {
                    val dataStoreUser = usersRepo.getCurrentUser()
                    if (dataStoreUser.firstName == _loginState.value.firstName &&
                            dataStoreUser.lastName == _loginState.value.lastName &&
                                dataStoreUser.phoneNumber == _loginState.value.phoneNumber
                    ){
                        _loginState.value = _loginState.value.copy(
                            wasLoggedIn = true
                        )
                    } else {
                        usersRepo.insertUser(
                            UserDb(
                                firstName = _loginState.value.firstName,
                                lastName = _loginState.value.lastName,
                                phoneNumber = _loginState.value.phoneNumber
                            )
                        )
                    }
                }
            }

            LoginUiEvent.ClearFirstName -> {
                _loginState.value = _loginState.value.copy(
                    firstName = ""
                )
            }
            LoginUiEvent.ClearLastName -> {
                _loginState.value = _loginState.value.copy(
                    lastName = ""
                )
            }
            LoginUiEvent.ClearPhoneNumber -> {
                _loginState.value = _loginState.value.copy(
                    phoneNumber = ""
                )
            }
        }
    }
}