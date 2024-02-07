package com.uolimzhanov.eshopeffectivemobile.model.entity

data class Price(
    val discount: Int = 0,
    val price: String = "",
    val priceWithDiscount: String = "",
    val unit: String = ""
)