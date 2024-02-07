package com.uolimzhanov.eshopeffectivemobile.ui.generic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags
import com.uolimzhanov.eshopeffectivemobile.ui.controls.EMSelectableChip
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * created by uolimzhanov on 06.02.2024
 */
@Composable
fun TagChipsSection(
    modifier: Modifier = Modifier,
    selectedTag: Tags = Tags.ALL,
    onSelectTag: (Tags) -> Unit = {}
){
    val scope = CoroutineScope(Dispatchers.Default)
    val listState = rememberLazyListState()
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        content = {
            items(Tags.entries){ tag ->
                EMSelectableChip(
                    onClick = {
                        onSelectTag(tag)
                        scope.launch {
                            listState.animateScrollToItem(tag.ordinal)
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(id = tag.titleId),
                            color = if(tag == selectedTag) Color.White else Color.Gray
                        )
                    },
                    selected = tag == selectedTag,
                    trailingIcon = {
                        if (tag == selectedTag) {
                            Icon(
                                painter = painterResource(id = R.drawable.small_close),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        }
    )
}

@Preview
@Composable
fun ChipSectionPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            TagChipsSection(
                selectedTag = Tags.ALL
            )
        }
    }
}