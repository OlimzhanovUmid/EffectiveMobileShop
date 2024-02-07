package com.uolimzhanov.eshopeffectivemobile.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by uolimzhanov on 07.02.2024
 */
@Entity(tableName = "items")
data class ItemDb (
    @PrimaryKey
    val id: String = "",
    val title: String = "",
)