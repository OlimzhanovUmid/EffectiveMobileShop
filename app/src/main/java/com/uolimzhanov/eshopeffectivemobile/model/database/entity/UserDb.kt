package com.uolimzhanov.eshopeffectivemobile.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by uolimzhanov on 05.02.2024
 */
@Entity(tableName = "Users")
data class UserDb(
    @PrimaryKey
    val id: Int? = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
)