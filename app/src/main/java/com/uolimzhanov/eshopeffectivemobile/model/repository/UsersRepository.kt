package com.uolimzhanov.eshopeffectivemobile.model.repository

import com.uolimzhanov.eshopeffectivemobile.model.database.EMDatabase
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by uolimzhanov on 06.02.2024
 */
@Singleton
class UsersRepository @Inject constructor(
    private val db: EMDatabase
){
    suspend fun insertUser(userDb: UserDb) {
        db.usersDao.insertUser(userDb)
    }

    suspend fun deleteUser(userDb: UserDb) {
        db.usersDao.deleteUser(userDb)
    }

    fun getUsers(): Flow<List<UserDb>> {
        return db.usersDao.getUsers()
    }
}