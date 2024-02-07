package com.uolimzhanov.eshopeffectivemobile.model.entity

import androidx.annotation.StringRes
import com.uolimzhanov.eshopeffectivemobile.R

/**
 * created by uolimzhanov on 06.02.2024
 */
enum class Tags (@StringRes val titleId: Int){
    ALL(R.string.tag_all),
    FACE(R.string.tag_face),
    BODY(R.string.tag_body),
    SUNTAN(R.string.tag_suntan),
    MASK(R.string.tag_mask)
}