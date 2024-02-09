package com.uolimzhanov.eshopeffectivemobile.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.ui.controls.EMButton
import com.uolimzhanov.eshopeffectivemobile.ui.controls.EMTextField
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Gray
import com.uolimzhanov.eshopeffectivemobile.ui.utils.PhoneNumberVisualTransformation

/**
 * created by uolimzhanov on 05.02.2024
 */
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    phoneMask: String = "+7 000 000-00-00",
    maskCharacter: Char = '0',
    state: LoginState = LoginState(),
    isFirstNameValid: Boolean,
    isLastNameValid: Boolean,
    isPhoneNumberValid: Boolean,
    onFirstNameChanged: (String) -> Unit = {},
    onLastNameChanged: (String) -> Unit = {},
    onPhoneNumberChanged: (String) -> Unit = {},
    onClearFirstName: () -> Unit = {},
    onClearLastName: () -> Unit = {},
    onClearPhoneNumber: () -> Unit = {},
    onLoginClick: () -> Unit = {}
){
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.White))
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(horizontal = 32.dp))
                .windowInsetsPadding(WindowInsets.safeDrawing).background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EMTextField(
                value = state.firstName,
                onValueChange = {
                    onFirstNameChanged(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                placeholder = {
                    Text(text = stringResource(R.string.first_name), color = Gray)
                },
                isError = state.firstName.isNotEmpty() && !isFirstNameValid,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                trailingIcon = {
                    if (state.firstName.isNotEmpty()) {
                        IconButton(onClick = {
                            onClearFirstName()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.big_close),
                                tint = Color.Black,
                                contentDescription = null,
                            )
                        }
                    }
                }
            )
            EMTextField(
                value = state.lastName,
                onValueChange = {
                    onLastNameChanged(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                placeholder = {
                    Text(text = stringResource(R.string.last_name), color = Gray)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                isError = state.lastName.isNotEmpty() && !isLastNameValid,
                trailingIcon = {
                    if (state.lastName.isNotEmpty()) {
                        IconButton(onClick = {
                            onClearLastName()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.big_close),
                                tint = Color.Black,
                                contentDescription = null,
                            )
                        }
                    }
                }
            )
            EMTextField(
                value = state.phoneNumber,
                onValueChange = { fieldValue ->
                    onPhoneNumberChanged(fieldValue.take(phoneMask.count { it == maskCharacter }))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                isError = state.phoneNumber.isNotEmpty() && !isPhoneNumberValid,
                placeholder = {
                    Text(text = stringResource(R.string.phone_number), color = Gray)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PhoneNumberVisualTransformation(mask = phoneMask, '0'),
                trailingIcon = {
                    if (state.phoneNumber.isNotEmpty()) {
                        IconButton(onClick = {
                            onClearPhoneNumber()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.big_close),
                                tint = Color.Black,
                                contentDescription = null,
                            )
                        }
                    }
                }
            )

            EMButton(
                onClick = { onLoginClick() },
                enabled = state.firstName.isNotEmpty()
                        && state.lastName.isNotEmpty()
                        && state.phoneNumber.isNotEmpty()
                        && isFirstNameValid
                        && isLastNameValid
                        && isPhoneNumberValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.log_in),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                appendLine("Нажимая кнопку “Войти”, Вы принимаете")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)){
                    append("условия программы лояльности")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter),
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            color = Gray
        )
    }

}

@Preview
@Composable
fun AuthScreenPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            LoginScreen(
                isFirstNameValid = true,
                isLastNameValid = true,
                isPhoneNumberValid = true
            )
        }
    }
}
