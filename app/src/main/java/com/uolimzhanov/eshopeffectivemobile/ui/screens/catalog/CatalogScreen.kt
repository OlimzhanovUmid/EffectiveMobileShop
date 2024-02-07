package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.Images
import com.uolimzhanov.eshopeffectivemobile.model.entity.SortOrder
import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem
import com.uolimzhanov.eshopeffectivemobile.ui.generic.ItemCard
import com.uolimzhanov.eshopeffectivemobile.ui.generic.TagChipsSection
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.utils.SortDropDown


/**
 * created by uolimzhanov on 06.02.2024
 */
@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    state: CatalogState = CatalogState(),
    selectedOrder: SortOrder = SortOrder.RATING,
    isExpanded: Boolean = true,
    onExpandedChange: () -> Unit = {},
    onDismiss: () -> Unit = {},
    onOpenClick: (UiItem) -> Unit = {},
    onSaveItem: (UiItem) -> Unit = {},
    onSortOrderSelected: (SortOrder) -> Unit = {},
    onSelectTag: (tag: Tags) -> Unit = {},
    paddingValues: PaddingValues
){
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    SortDropDown(
                        isExpanded = isExpanded,
                        onExpandChange = { onExpandedChange() },
                        onDismiss = { onDismiss() },
                        onSelected = {
                            onSortOrderSelected(it)
                        },
                        selectedOrder = selectedOrder
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = null
                        )
                        Text(text = stringResource(id = R.string.filters))
                    }
                }
                TagChipsSection(
                    modifier = Modifier.padding(start = 8.dp),
                    selectedTag = state.selectedTag,
                    onSelectTag = onSelectTag
                )
            }
        },
        modifier = modifier.padding(paddingValues),
    ) { scaffoldPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = scaffoldPadding,
            content = {
                items(state.items){ item ->
                    Images.images[item.id]?.let { list ->
                        ItemCard(
                            item = item,
                            modifier = Modifier.padding(2.dp),
                            onOpenClick = {
                                if(item.id == it.id) {
                                    onOpenClick(it)
                                }
                            },
                            images = list,
                            onSaveClick = {onSaveItem(it)}
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun CatalogScreenPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            /*val items = listOf(
                Item(subtitle = "1"),
                Item(subtitle = "2"),
                Item(subtitle = "3"),
                Item(subtitle = "4"),
                Item(subtitle = "5"),
                Item(subtitle = "6"),
            )
            CatalogScreen(paddingValues = PaddingValues(), state = CatalogState(Catalog(items)))*/
        }
    }
}