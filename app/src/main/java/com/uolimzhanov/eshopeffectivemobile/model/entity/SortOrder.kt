package com.uolimzhanov.eshopeffectivemobile.model.entity

import androidx.annotation.StringRes
import com.uolimzhanov.eshopeffectivemobile.R

/**
 * created by uolimzhanov on 06.02.2024
 */
enum class SortOrder(@StringRes val textId: Int) {
    RATING(R.string.sort_by_rating),
    PRICE_ASC(R.string.sort_by_price_asc),
    PRICE_DESC(R.string.sort_by_price_desc)
}