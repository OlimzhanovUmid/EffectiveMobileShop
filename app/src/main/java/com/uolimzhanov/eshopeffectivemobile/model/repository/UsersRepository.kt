package com.uolimzhanov.eshopeffectivemobile.model.repository

import com.uolimzhanov.eshopeffectivemobile.model.database.EMDatabase
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import com.uolimzhanov.eshopeffectivemobile.utils.DataStoreManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by uolimzhanov on 06.02.2024
 */
@Singleton
class UsersRepository @Inject constructor(
    private val db: EMDatabase,
    private val dataStoreManager: DataStoreManager
){
    suspend fun insertUser(userDb: UserDb) {
        db.usersDao.insertUser(userDb)
        dataStoreManager.saveUserId(userDb.id)
    }

    suspend fun deleteUser(userDb: UserDb) {
        dataStoreManager.deleteUserId()
        db.usersDao.deleteUser(userDb)
    }

    fun getUsers(): Flow<List<UserDb>> {
        return db.usersDao.getUsers()
    }

    suspend fun getUserById(): UserDb {
        return db.usersDao.getUsersById(dataStoreManager.getUserId() ?: 1) ?: UserDb(-1,"error", "error", "error")
    }
}