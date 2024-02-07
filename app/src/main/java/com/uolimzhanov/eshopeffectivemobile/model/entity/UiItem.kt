package com.uolimzhanov.eshopeffectivemobile.model.entity

/**
 * created by uolimzhanov on 08.02.2024
 */
data class UiItem (
    val isLiked: Boolean,
    val available: Int = 0,
    val description: String = "",
    val feedback: Feedback = Feedback(),
    val id: String = "",
    val info: List<Info> = listOf(),
    val ingredients: String = "",
    val price: Price = Price(),
    val subtitle: String = "",
    val tags: List<String> = listOf(),
    val title: String = ""
)