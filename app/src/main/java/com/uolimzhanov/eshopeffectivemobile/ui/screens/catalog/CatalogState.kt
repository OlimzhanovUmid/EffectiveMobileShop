package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem

/**
 * created by uolimzhanov on 06.02.2024
 */
data class CatalogState(
    val items: List<UiItem> = emptyList(),
    val selectedTag: Tags = Tags.ALL,
    val openedItem: UiItem = UiItem(false),
    val currentUser: UserDb = UserDb(-1,"","","")
)