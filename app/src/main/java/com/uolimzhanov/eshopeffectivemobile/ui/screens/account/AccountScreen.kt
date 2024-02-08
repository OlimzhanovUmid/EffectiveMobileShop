package com.uolimzhanov.eshopeffectivemobile.ui.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem
import com.uolimzhanov.eshopeffectivemobile.ui.controls.EMButton
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Gray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.LightGray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Orange
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 08.02.2024
 */
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    user: UserDb = UserDb(0, "", "", ""),
    items: List<UiItem> = emptyList(),
    onExitClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.account), contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                append(user.firstName)
                                append(" ")
                                append(user.lastName)
                            },
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = user.phoneNumber,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.exit_button), contentDescription = null)
                    }
                }
            }
            Card(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.heart_outlined), tint = Pink, contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Избранное",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "${items.size}",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.shop), tint = Pink, contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Магазины",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.feedback), tint = Orange, contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Обратная связь",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.offert), tint = Gray, contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Оферта",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(LightGray, RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = LightGray
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(R.drawable.refund), tint = Gray, contentDescription = null)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(4.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Возврат товара",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = null)
                    }
                }
            }
        }
        EMButton(
            onClick = { onExitClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = LightGray,
                contentColor = Color.Black
            )
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Выйти"
            )
        }
    }
}

@Preview
@Composable
fun AccountScreenPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            AccountScreen(
                user = UserDb(0, "Марина", "Цветаева", "+7 988 989-99-78")
            )
        }
    }
}