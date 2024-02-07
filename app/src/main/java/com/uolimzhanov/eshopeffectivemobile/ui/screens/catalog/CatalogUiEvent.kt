package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import com.uolimzhanov.eshopeffectivemobile.model.entity.Item
import com.uolimzhanov.eshopeffectivemobile.model.entity.Tags

/**
 * created by uolimzhanov on 06.02.2024
 */
sealed class CatalogUiEvent {
    data class SelectTag(val tag: Tags): CatalogUiEvent()
    data class OpenItem(val item: Item): CatalogUiEvent()
}