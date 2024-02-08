package com.uolimzhanov.eshopeffectivemobile.model.extensions

/**
 * created by uolimzhanov on 07.02.2024
 */
fun String.isCyrillic(): Boolean {
    val regex = Regex("\\p{IsCyrillic}+")
    return regex.matches(this)
}