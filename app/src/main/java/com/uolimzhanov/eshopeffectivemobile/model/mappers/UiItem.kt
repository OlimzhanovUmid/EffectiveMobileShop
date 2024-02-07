package com.uolimzhanov.eshopeffectivemobile.model.mappers

import com.uolimzhanov.eshopeffectivemobile.model.entity.Item
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem

/**
 * created by uolimzhanov on 08.02.2024
 */
fun Item.toUiItem(isLiked: Boolean)
    = UiItem(
        isLiked = isLiked,
        available = this.available,
        description = this.description,
        feedback = this.feedback ,
        id = this.id,
        info = this.info,
        ingredients = this.ingredients,
        price = this.price,
        subtitle = this.subtitle,
        tags = this.tags,
        title = this.title,
    )

fun UiItem.toItem()
        = Item(
        available = this.available,
        description = this.description,
        feedback = this.feedback ,
        id = this.id,
        info = this.info,
        ingredients = this.ingredients,
        price = this.price,
        subtitle = this.subtitle,
        tags = this.tags,
        title = this.title,
)
