package com.uolimzhanov.eshopeffectivemobile.ui.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.LightPink

/**
 * created by uolimzhanov on 01.02.2024
 */
@Composable
fun EMButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        disabledContainerColor = LightPink,
        disabledContentColor = Color.White
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
){
    Button(
        onClick,
        modifier,
        enabled,
        shape,
        colors,
        elevation,
        border,
        contentPadding,
        interactionSource,
        content
    )
}

@PreviewLightDark
@Composable
fun ButtonsPreview(){
    EShopEffectiveMobileTheme {
        Column {
            EMButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button")
            }
            EMButton(
                onClick = { /*TODO*/ }, enabled = false
            ) {
                Text(text = "Button")
            }
        }
    }
}