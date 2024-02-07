package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import com.uolimzhanov.eshopeffectivemobile.model.entity.Catalog
import com.uolimzhanov.eshopeffectivemobile.model.entity.Item
import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags

/**
 * created by uolimzhanov on 06.02.2024
 */
data class CatalogState(
    val items: List<UiItem> = emptyList(),
    val selectedTag: Tags = Tags.ALL,
    val openedItem: UiItem = UiItem(false),
)