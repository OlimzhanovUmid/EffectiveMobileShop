package com.uolimzhanov.eshopeffectivemobile.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uolimzhanov.eshopeffectivemobile.model.database.dao.UsersDao
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb

/**
 * created by uolimzhanov on 05.02.2024
 */

@Database(
    entities = [
        UserDb::class
    ],
    version = 1
)
abstract class EMDatabase: RoomDatabase() {
    abstract val usersDao: UsersDao
}
