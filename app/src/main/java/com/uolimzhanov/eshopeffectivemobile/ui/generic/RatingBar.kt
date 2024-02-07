package com.uolimzhanov.eshopeffectivemobile.ui.generic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Orange

/**
 * created by uolimzhanov on 07.02.2024
 */
@Composable
fun RatingBar(
    rating: Float = 0f
){
    Row (
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(5) { index ->
            Icon (
                painter = when{
                    (rating - index).toInt() > 0 -> painterResource(id = R.drawable.star)
                    (rating - index) in 0.1f..0.9f -> painterResource(id = R.drawable.star_half_full)
                    else -> painterResource(id = R.drawable.star_outline)
                },
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .padding(4.dp),
                tint = Orange
            )
        }
    }
}

@Preview
@Composable
fun RatingBarPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            RatingBar(4.3f)
        }
    }
}