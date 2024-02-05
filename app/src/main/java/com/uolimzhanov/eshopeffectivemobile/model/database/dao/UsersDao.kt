package com.uolimzhanov.eshopeffectivemobile.model.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import kotlinx.coroutines.flow.Flow


/**
 * created by uolimzhanov on 05.02.2024
 */
@Dao
interface UsersDao{
    @Insert
    suspend fun insertUser(userDb: UserDb)

    @Delete
    suspend fun deleteUser(userDb: UserDb)

    @Query("select * from users")
    fun checkIfUserExists() : Flow<List<UserDb>>
}