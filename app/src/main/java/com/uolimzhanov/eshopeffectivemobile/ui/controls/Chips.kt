package com.uolimzhanov.eshopeffectivemobile.ui.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.uolimzhanov.eshopeffectivemobile.ui.theme.DarkBlue
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme

/**
 * created by uolimzhanov on 06.02.2024
 */
@Composable
fun EMSelectableChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(100),
    colors: ChipColors = AssistChipDefaults.assistChipColors().copy(
        containerColor = if(selected) DarkBlue else Color.LightGray,
    ),
    elevation: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    border: BorderStroke? = AssistChipDefaults.assistChipBorder(
        enabled = enabled,
        borderColor = if(selected) DarkBlue else Color.LightGray
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
){
    AssistChip(
        onClick,
        label,
        modifier,
        enabled,
        leadingIcon,
        trailingIcon,
        shape,
        colors,
        elevation,
        border,
        interactionSource
    )
}

@Preview
@Composable
fun EMChipPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            Row {
                EMSelectableChip(
                    label = {},
                    onClick = {}
                )
                EMSelectableChip(
                    label = {},
                    onClick = {},
                    selected = true
                )
            }
        }
    }
}