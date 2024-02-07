package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem

/**
 * created by uolimzhanov on 06.02.2024
 */
sealed class CatalogUiEvent {
    data class SelectTag(val tag: Tags): CatalogUiEvent()
    data class OpenItem(val item: UiItem): CatalogUiEvent()
    data class SaveItem(val item: UiItem): CatalogUiEvent()
}