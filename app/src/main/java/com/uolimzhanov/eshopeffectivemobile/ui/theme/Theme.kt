package com.uolimzhanov.eshopeffectivemobile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EMColorScheme = lightColorScheme(
    primary = Pink,
    secondary = LightPink,
    tertiary = LightGrey,
    onPrimary = Color.White,
    surface = Color.White,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)


@Composable
fun EShopEffectiveMobileTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = EMColorScheme,
        typography = Typography,
        content = content
    )
}